package com.nalitnyk.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/*
    Службова логіка (логування).
    LoggingAspect — аспектний клас.
*/
@Component
/*
    Клас-аспект відповідає за наскрізну (службову) функціональність.
    Зверніть увагу, що, не дивлячись на підключення Spring AOP, все одно потрібна бібліотека AspectJ
*/
@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @Before("execution(public ResponseEntity getAllRates())")
//    @Before("execution(* com.nalitnyk.testpackage.ExchangeRateController*(..))")
//    @Before("execution(* com.howtodoinjava.app.service.impl.EmployeeManagerImpl.*(..))")
//    @Before("execution(* com.nalitnyk.testpackage.ExchangeRateController.*(..))")
//    @Before("@com.nalitnyk.testpackage.ExchangeRateController()")
    @Before(value = "execution(* com.nalitnyk.controller.*.*(..))")
    public void beforeRateAll() {
        System.out.println("hehe");
    }

//    @Around("execution(* com.dummy.pkg..*.*(..))")
//    public Response<Object> beforeServiceAspect(ProceedingJoinPoint joinPoint) throws Exception {
//
//        Object[] signatureArgs = joinPoint.getArgs();
//
//        String sessionId=(String) signatureArgs[0];
//
//
//        if(null==sessionId || sessionId.isEmpty() || !loginService.getUserInfo(sessionId))
//        {
//            Response.setStatusCode("401");
//            Response.setResultString("Unauthorized User");
//            return  Response;
//        }
//        return joinPoint.proceed(args);
//    }

    // Інші методи шукайте в додаткових джерелах
}
