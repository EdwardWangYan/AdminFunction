package com.wy.integration.configurer.shiro;

import com.google.common.base.Objects;
import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.wy.integration.utils.Constants;
import com.wy.integration.utils.Encodes;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
	@Resource
	private SysUserService sysUserService;

	public UserRealm() {

	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		String username = (String)token.getPrincipal();
		SysUser user=sysUserService.findBy("loginName",username);
		if(user == null) throw new UnknownAccountException();//没找到帐号
		if(ConstantsFlag.IsDeleteFlag.DELETED.getValue().intValue()==user.getLocked().intValue()) throw new LockedAccountException(); //帐号锁定
		byte[] salt = Encodes.decodeHex(user.getSalt());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				new ShiroUser(user.getId(),user.getLoginName(),user.getNickName(), user.getIcon()),
				user.getPassword(), //密码
				ByteSource.Util.bytes(salt),
				getName()  //realm name
		);
		return authenticationInfo;
	}

	public void removeUserAuthorizationInfoCache(String username) {
		SimplePrincipalCollection pc = new SimplePrincipalCollection();
		pc.add(username, super.getName());
		super.clearCachedAuthorizationInfo(pc);
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Constants.HASH_ALGORITHM);
		matcher.setHashIterations(Constants.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}



	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public String id;
		public String loginName;
		public String nickName;
		public String icon;

		public ShiroUser(String id, String loginName, String nickName,String icon) {
			this.id = id;
			this.loginName = loginName;
			this.nickName = nickName;
			this.icon=icon;
		}

		public String getloginName() {
			return loginName;
		}
		public String getNickName() {
			return nickName;
		}
		public String getIcon() {
			return icon;
		}
		public String getId() {
			return id;
		}



		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return nickName;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(loginName);
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				return other.loginName == null;
			} else return loginName.equals(other.loginName);
		}
	}
}