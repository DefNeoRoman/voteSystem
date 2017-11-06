package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    //  http://www.programming-free.com/2015/10/spring-security-spring-data-jpa-video.html
//    @Autowired
//    ConfigurableApplicationContext context;
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        DataSource dataSource = (DataSource)context.getBean("dataSource");
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select name,password, from users where name=?")
//                .authoritiesByUsernameQuery("select user_id, role from user_roles where user_id=?");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//                .permitAll();
//        http.exceptionHandling().accessDeniedPage("/403");
//    }


}
