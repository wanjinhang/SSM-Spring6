package com.wansui.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 21:03
 */
//声明
@Aspect
@Component
public class MyAdvice {

    /**
     *切面点声明方法
     */
    @Pointcut("execution(* *..StudentDaoImpl.*(..))")
    public void declarPointCut(){

    }


    /**
     *前置增强
     */
    @Before(value = "declarPointCut()")
    public void before(JoinPoint joinPoint) {
        // 获取调用 方法名 joinPoint.getSignature().
        String methodName = joinPoint.getSignature().getName();
        //获取 全类名
        String fullClassName = joinPoint.getSignature().getDeclaringTypeName();
        //声明类型
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        //权限
        int modifiers = joinPoint.getSignature().getModifiers();
        String string = Modifier.toString(modifiers);
        //获取外界调用目标方法时传入的实参列表
        joinPoint.getArgs();
        System.out.println("[AOP前置通知] 方法开始了"+methodName);
    }

    /**
     *
     */
    @AfterReturning(value = "declarPointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP返回通知] "+methodName+"方法成功结束了，返回值是：" + result);
    }

    @After(value = "declarPointCut()")
    public void after() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }

    @AfterThrowing(value = "declarPointCut()",throwing = "throwable")
    public void afterThrowing(Throwable throwable) {

    }
}
