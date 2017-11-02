package com;

import org.hibernate.boot.jaxb.SourceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.datajpa.MealRepository;
import service.*;

import javax.jws.soap.SOAPBinding;

@ComponentScan(basePackages = {
        "web","service","repository","com"},
        basePackageClasses = SpringBootWebApplication.class)
@SpringBootApplication
@EntityScan("model")
@EnableJpaRepositories("repository.datajpa")

public class SpringBootWebApplication extends SpringBootServletInitializer{


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =  SpringApplication.run(SpringBootWebApplication.class, args);
//
//        context.getBean(MealService.class).testSave();
//        System.out.println(context.getBean(MealService.class).testGet());
//        System.out.println(context.getBean(PlaceService.class).getAllTOs());
    }

}
