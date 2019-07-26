package com.dqcer.platform.common.aspect.annotation;

import com.dqcer.platform.common.constant.CommonConstant;

import java.lang.annotation.*;

/**
 * 系统操作日志
 * @Author dongqin
 * @Description
 * @Date 8:38 2019/7/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PlatformLog {

	/**
	 * 日志内容
	 * 
	 * @return
	 */
	String value() default "";


	/**
	 * 日志类型
	 *
	 *  1/登录日志 2/操作日志 3/定时任务
	 * @return
	 */
	int logType() default CommonConstant.LOG_TYPE_2;
}
