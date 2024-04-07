package edu.miu.springaop.aop.aspect;

import edu.miu.springaop.aop.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Configuration
public class AopIsAwesomeAdvice {
    @Before("execution(* edu.miu.springaop.service.*.*(..))")
    public void aopawesomebeforemethod(JoinPoint joinPoint){
        HttpServletRequest request = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if(!request.getMethod().equalsIgnoreCase("POST")){
            return;
        }

        String headerValue = request.getHeader("AOP-IS-AWESOME");
        if(headerValue == null){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header missing or invalid");
        }

    }

}

