package com.wy.integration.annotation;

import java.lang.annotation.*;

/**
 * Created by Edward on 2018/06/26.
 * todo:
 * 类SysLog的功能描述:
 * 系统日志注解
 */
@Target(ElementType.METHOD)//注解的作用目标 方法
@Retention(RetentionPolicy.RUNTIME)//注解的保留位置　 解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented
public @interface SysLog {
    String value() default "";
}
