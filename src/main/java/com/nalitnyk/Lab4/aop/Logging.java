package com.nalitnyk.Lab4.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public
class Logging {
    private static final Logger LOGGER = LogManager.getLogger(Logging.class);

    @Before("execution(* com.nalitnyk.Lab4.controllers.ExchangeController..*(..)) )")
    public void beforeUpdateDb() {
        System.out.println("\n\n[ЛОГ] Перевірка на оновлення курсу валют почалася...\n\n\n");

    }
    @Before("execution(public void com.nalitnyk.Lab4.controllers.ExchangeController.updateTables())")
    public void afterUpdateTables() {
        System.out.println("\n\n[ЛОГ] Почалося оновлення курсу валют...\n\n\n");

    }
    @After("execution(* com.nalitnyk.Lab4.controllers.ExchangeController..*(..)) )")
    public void afterUpdateDb() {
        System.out.println("\n\n[ЛОГ] Перевірка на оновлення курсу валют завершилася...\n\n\n");

    }

//    @Before("(сom.nalitnyk.Lab4.controllers.ExchangeController.updateDB() )")
    @Before("execution(public void com.nalitnyk.Lab4.controllers.ExitController.shutdownApp())")
    public void hehe() {
        LOGGER.info("\n\n\nЗупиняємо сервак...\n\n\n");
    }

}
