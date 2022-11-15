package com.nalitnyk.Lab4.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public
class Logging {
    @Before("execution(private void updateTables())")
    public void beforeUpdateDb() {
        System.out.println("[ЛОГ] Виконується оновлення БД...");
    }
}
