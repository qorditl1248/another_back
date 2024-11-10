package com.starbucksorder.another_back.aspect;

import com.starbucksorder.another_back.dto.admin.request.ReqSigninDto;
import com.starbucksorder.another_back.exception.ValidException;
import com.starbucksorder.another_back.service.MenuService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

@Aspect
@Component
public class ValidAspect {
    @Autowired
    private MenuService menuService;

    @Pointcut("@annotation(com.starbucksorder.another_back.aspect.annotation.ValidAop)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aspect동작");
        Object[] args = proceedingJoinPoint.getArgs();
        BeanPropertyBindingResult bindingResult = null;
        for (Object arg : args) {
            if (arg instanceof ReqSigninDto) {
                System.out.println(arg);
            }
        }
        for (Object arg : args) {
            if (arg instanceof BeanPropertyBindingResult) {
                bindingResult = (BeanPropertyBindingResult) arg;
            }
        }

        switch (proceedingJoinPoint.getSignature().getName()) {
            case "signIn":
                break;
            case "modifyMenu":
                break;
        }

        if (bindingResult.hasErrors()) {
            throw new ValidException("유효성 검사 오류", bindingResult.getFieldErrors());
        }

        return proceedingJoinPoint.proceed();
    }
}
