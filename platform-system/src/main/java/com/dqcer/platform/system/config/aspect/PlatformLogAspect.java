package com.dqcer.platform.system.config.aspect;

import com.dqcer.platform.common.aspect.annotation.PlatformLog;
import com.dqcer.platform.system.web.dao.log.LogDao;
import com.dqcer.platform.system.web.vo.log.entity.SysLogEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志
 *
 * @Author dongqin
 * @Description
 * @Date 8:44 2019/7/26
 */
@Aspect
@Configuration
public class PlatformLogAspect {

    @Autowired
    private LogDao logDao;

    /**
     * execution：用于匹配方法执行的连接点
     * within：用于匹配指定类型内的方法执行
     * this：用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配
     * target：用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配
     * @target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
     * @within：用于匹配所以持有指定注解类型内的方法
     * @args：用于匹配当前执行的方法传入的参数持有指定注解的执行
     * @annotation-- 匹配当前执行方法持有指定注解的方法
     */
    @Pointcut("@annotation(com.dqcer.platform.common.aspect.annotation.PlatformLog)")
    public void pointcut() {

    }

    /**
     * 环绕通知
     *
     * @param point 通过ProceedingJoinPoint想要获取当前执行的方法
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        savePlatformLog(point, time);
        return result;
    }

    /**
     * 保存系统日志
     *
     * @param point
     * @param time
     */
    private void savePlatformLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLogEntity entity = new SysLogEntity();
        PlatformLog annotation = method.getAnnotation(PlatformLog.class);
        if (annotation != null) {
            entity.setLogContent(annotation.value());
            entity.setLogType(annotation.logType());
        }
        //  方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        entity.setMethod(className + "." + methodName);

        //  请求的参数
        Object[] args = point.getArgs();
        String params = "";
        for (int i = 0; i < args.length; i++) {
            params += "  " + args[i] + ": " + args[i];
        }
        //String params = JSONObject.toJSONString(args);
        entity.setRequestParam(params);

        //获取request
       /* HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        //获取登录用户信息
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        if(sysUser!=null){
            sysLog.setUserid(sysUser.getUsername());
            sysLog.setUsername(sysUser.getRealname());

        }*/
       entity.setUid(1);
       entity.setUsername("测试管理源");
       entity.setName("dqcer");
       entity.setOperateType(1);
        //耗时
        entity.setCostTime(time);
        entity.setCreateTime(new Date());

        //  状态码
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        int status = httpServletResponse.getStatus();
        entity.setResponseStatus(status);
        logDao.insert(entity);

        // HttpServletResponse.SC_BAD_REQUEST;

    }
}
