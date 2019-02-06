package com.webshopproject.webshopprojectbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig  { //extends WebSecurityConfigurerAdapter

    //    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//
//
//    public SpringSecurityConfig(@Qualifier("dataSource") DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    //database
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth
////            .inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled from user where username=?")
//                .authoritiesByUsernameQuery("select username, role from user where username=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests().antMatchers("/*").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .defaultSuccessUrl("/user/home", true)
////                .usernameParameter("username").passwordParameter("password")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login")
////                .permitAll();
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(restAuthenticationEntryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/item/*").authenticated()
////                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin().loginPage("/user/login")
////                .successHandler(mySuccessHandler)
////                .failureHandler(myFailureHandler)
//                .and()
//                .logout();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/img/**", "/templates/**");
//    }
}
