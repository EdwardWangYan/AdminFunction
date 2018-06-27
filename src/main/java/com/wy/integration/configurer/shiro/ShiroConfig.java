package com.wy.integration.configurer.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

	private Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	@Value("${spring.redis.host}")
	private String jedisHost;

	@Value("${spring.redis.port}")
	private Integer jedisPort;

	@Value("${spring.redis.password}")
	private String jedisPassword;

	/**
	 * 手动注入shiroFilter
	 * **/
	@Bean
	public FilterRegistrationBean delegatingFilterProxy(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
		proxy.setTargetFilterLifecycle(true);
		proxy.setTargetBeanName("shiroFilter");
		filterRegistrationBean.setFilter(proxy);
		filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR,DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE);
		return filterRegistrationBean;
	}

	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = shiroFactoryBean(securityManager);
		Map<String, String> chain = new LinkedHashMap<>();
		List<String> anonUrl = new ArrayList<>();
		addDefaultAnonUrl(anonUrl);
		addAnonUrl4Test(anonUrl);
		for (String url : anonUrl) {
			chain.put(url, "anon");
		}
		chain.put("/**", "authc");
		bean.setFilterChainDefinitionMap(chain);
		return bean;
	}
	/**
	 * 设置过滤器
	 */
	public static ShiroFilterFactoryBean shiroFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		// TODO: 2018/5/23 0023   过来器还没有配置 

		return bean;
	}



	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		// 设置realm.
		defaultWebSecurityManager.setRealm(userRealm());
		// 注入记住我管理器;
		defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
		//设置sessionManager
		defaultWebSecurityManager.setSessionManager(webSessionManager());
		//设置缓存
		defaultWebSecurityManager.setCacheManager(cacheManager());
		return defaultWebSecurityManager;
	}
	@Bean
	public SessionManager webSessionManager(){
		DefaultWebSessionManager manager = new DefaultWebSessionManager();
		//设置session过期时间为1小时(单位：毫秒)，默认为30分钟
		manager.setGlobalSessionTimeout(60 * 60 * 1000);
		manager.setSessionValidationSchedulerEnabled(true);
		manager.setSessionDAO(redisSessionDAO());
		return manager;
	}

	@Bean
	public RedisSessionDAO redisSessionDAO(){
		RedisSessionDAO sessionDAO = new RedisSessionDAO();
		sessionDAO.setKeyPrefix("wl_");
		sessionDAO.setRedisManager(redisManager());
		return sessionDAO;
	}

	@Bean("myCacheManager")
	public RedisCacheManager cacheManager(){
		RedisCacheManager manager = new RedisCacheManager();
		manager.setRedisManager(redisManager());
		return manager;
	}
	@Bean
	public RedisManager redisManager(){
		RedisManager manager = new RedisManager();
		manager.setHost(jedisHost);
		manager.setPort(jedisPort);
		//这里是用户session的时长 跟上面的setGlobalSessionTimeout 应该保持一直（上面是1个小时 下面是秒做单位的 我们设置成3600）
		manager.setExpire(60 * 60);
		manager.setPassword(jedisPassword);
		return manager;
	}
	// 注入记住我管理器;
	@Bean
	public CookieRememberMeManager rememberMeManager(){
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCookie(rememberMeCookie());
		//rememberme cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
		//KeyGenerator keygen = KeyGenerator.getInstance("AES");
		//SecretKey deskey = keygen.generateKey();
		//System.out.println(Base64.encodeToString(deskey.getEncoded()));
		//rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
		rememberMeManager.setCipherKey(Base64.decode("MgEiD3YvjUNBKWMz9lncyQ=="));
		return rememberMeManager;
	}

	// 设置realm.
	@Bean
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 */

	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
	/**
	 * Shiro生命周期处理器  保证实现了Shiro内部lifecycle函数的bean执行
	 */
	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public SimpleCookie rememberMeCookie(){
		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setHttpOnly(true);
		//记住我有效期长达30天
		cookie.setMaxAge(2592000);
		return cookie;
	}


	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码;
	 * ）
	 * 可以扩展凭证匹配器，实现 输入密码错误次数后锁定等功能，下一次
	 */
/*	@Bean(name = "credentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		//散列的次数，比如散列两次，相当于 md5(md5(""));
		hashedCredentialsMatcher.setHashIterations(2);
		//storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}*/



	private static void addDefaultAnonUrl(List<String> anonUrl) {
		anonUrl.add("/**/favicon.ico");
		anonUrl.add("/sysuser/**");
	}

	private static void addAnonUrl4Test(List<String> anonUrl) {
		//swagger
		anonUrl.add("/webjars/**");
		anonUrl.add("/v2/**");
		anonUrl.add("/swagger*");
		anonUrl.add("/swagger*/**");

		//spring boot actuator
		anonUrl.add("/loggers/*");
		anonUrl.add("/loggers*");
		anonUrl.add("/health");
		anonUrl.add("/metrics/*");
		anonUrl.add("/metrics*");
		anonUrl.add("/info");
		anonUrl.add("/trace");
		anonUrl.add("/dump");
		anonUrl.add("/auditevents");
		anonUrl.add("/configprops");
		anonUrl.add("/logfile");
		anonUrl.add("/env/*");
		anonUrl.add("/env*");
		anonUrl.add("/mappings");
		anonUrl.add("/autoconfig");
		anonUrl.add("/heapdump*");
		anonUrl.add("/beans");
		anonUrl.add("/shutdown");
	}

}