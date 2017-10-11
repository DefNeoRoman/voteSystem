package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import service.MealService;
import service.MenuService;

@ComponentScan(basePackages = {
        "web","service","repository","com"},
        basePackageClasses = SpringBootWebApplication.class)
@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer{


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context=  SpringApplication.run(SpringBootWebApplication.class, args);
        context.getBean(MealService.class).fillRepository();
        context.getBean(MenuService.class).fillRepository();

    }

}
