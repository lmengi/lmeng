package com.lmeng.intercept;

import com.lmeng.controller.base.BaseController;
import com.lmeng.utils.HttpSessionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 静态调用session的拦截器
 *
 * @author fengshuonan
 * @date 2016年11月13日 下午10:15:42
 */
@Aspect
@Component
public class SessionInterceptor extends BaseController {

   @Pointcut("execution(* com.lmeng.*..controller.*.*(..))")
    public void cutService() {
    }

    @Around("cutService()")
    public Object sessionKit(ProceedingJoinPoint point) throws Throwable {
        HttpSessionUtil.put(super.getHttpServletRequest().getSession());
        try {
            return point.proceed();
        } finally {
            HttpSessionUtil.remove();
        }
    }
}
