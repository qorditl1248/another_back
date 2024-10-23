package com.starbucksorder.another_back.aspect;

import com.starbucksorder.another_back.dto.admin.request.menu.ReqAdminModifyDto;
import com.starbucksorder.another_back.repository.CategoryMapper;
import com.starbucksorder.another_back.repository.MenuMapper;
import com.starbucksorder.another_back.repository.OptionMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class NameDuplicateAspect {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Pointcut("@annotation(com.starbucksorder.another_back.aspect.annotation.NameDuplicate)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for (Object arg : args) {
            if (arg instanceof BeanPropertyBindingResult) {
                bindingResult = (BeanPropertyBindingResult) arg;
            }
        }

        switch (proceedingJoinPoint.getSignature().getName()) {
            case "modifyMenu":
                isDuplicateName("menu", args, bindingResult);
                break;
            case "modifyOption":
                isDuplicateName("option", args, bindingResult);
                break;
            case "modifyCategory":
                isDuplicateName("category", args, bindingResult);
                break;

            default:
                System.out.println("안걸림");
                break;
        }
        if (bindingResult.hasErrors()) {
//            throw new DuplicateNameException("중복된 이름입니다");
        }

        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    // 모듈화 ? 공통분모를 뽑기위해선 일관된 규칙이 존재해야한다
    private void isDuplicateName(String name, Object[] args, BindingResult bindingResult) {
        switch (name) {
            case "menu":
                ReqAdminModifyDto dto = null;
                for (Object arg : args) {
                    if (arg instanceof ReqAdminModifyDto) {
                        dto = (ReqAdminModifyDto) arg;
                    }
                    if (menuMapper.findByMenuName(dto.getMenuName()) != null) {

                    }
                }
                break;
            case "option":
                break;
            case "category":
                break;
            default:
                throw new RuntimeException("메소드를 찾을 수 없습니다");
        }
    }

}
