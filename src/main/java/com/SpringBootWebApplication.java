package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.UserRepository;
import web.controllers.UserController;

@SpringBootApplication
@ComponentScan(basePackages = {
        "web", "service", "repository", "com"},
        basePackageClasses = SpringBootWebApplication.class)
@EntityScan("model")
@EnableJpaRepositories("repository")
public class SpringBootWebApplication extends SpringBootServletInitializer {


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);
        System.out.println(context.getBean(UserController.class).getAll());
        System.out.println(context.getBean(UserRepository.class).findByUsername("regular").getAuthorities());
    }

}
