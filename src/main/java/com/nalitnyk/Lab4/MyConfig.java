package com.nalitnyk.Lab4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nalitnyk.Lab4.controllers")
@EnableAspectJAutoProxy
public class MyConfig {
}
