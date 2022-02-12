package com.kushnirmark.spring.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("STUDENT","TEACHER","ADMIN")
                .antMatchers("allStudents").hasAnyRole("STUDENT","TEACHER","ADMIN")
                .antMatchers("/allDisciplines").hasAnyRole("STUDENT","TEACHER","ADMIN")
                .antMatchers("/allSemestrs").hasAnyRole("STUDENT","TEACHER","ADMIN")
                .antMatchers("/creteNewStudent").hasRole("ADMIN")
                .antMatchers("/updateStudent").hasRole("ADMIN")
                .antMatchers("/creteNewDiscipline").hasRole("ADMIN")
                .antMatchers("/updateDiscipline").hasRole("ADMIN")
                .antMatchers("/creteNewSemester").hasRole("ADMIN")
                .antMatchers("/updateDiscipline").hasRole("ADMIN")
                .and().formLogin().permitAll();
    }
}
