package com.starbucksorder.another_back.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.starbucksorder.another_back.aspect.annotation.Log)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
        log.info("------------------------------------------------------------------------------------------------------------------------");
        log.info(">>>>>> 주요메소드명 :{}<<<<<<", signature.getName()); // 주요메소드명
        log.info(">>>>>> 디클레어링네임 :{}<<<<<<", signature.getDeclaringTypeName()); // 주요메소드가 있는 클래스
        log.info(">>>>>> 디클레어링타입의 심플네임 :{}<<<<<<", signature.getDeclaringType().getSimpleName()); // 클래스의 심플네임
        log.info(">>>>>> 매개변수 객체명 : {}<<<<<<", signature.getParameterNames()); // 파라미터 객체명
        log.info(">>>>>> 해당객체에 들어가는 값들 : {}<<<<<<", proceedingJoinPoint.getArgs()); // 객체를 배열로 가지고 옴
        log.info("------------------------------------------------------------------------------------------------------------------------");

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {

            log.info(">>>>>>객체 : {}<<<<<<", arg);
            log.info(">>>>>>객체의 클래스 : {}<<<<<<", arg.getClass().getSimpleName());
        }
        log.info("------------------------------------------------------------------------------------------------------------------------");
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
