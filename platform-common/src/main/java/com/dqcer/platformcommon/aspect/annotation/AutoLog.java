package com.dqcer.platformcommon.aspect.annotation;

import com.dqcer.platformcommon.constant.CommonConstant;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @Author scott
 * @email jeecgos@163.com
 * @Date 2019年1月14日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

	/**
	 * 日志内容
	 * 
	 * @return
	 */
	String value() default "";

	/**
	 * 日志类型
	 * 
	 * @return 0:操作日志;1:登录日志;2:定时任务;
	 */
	int logType() default CommonConstant.LOG_TYPE_2;
}
