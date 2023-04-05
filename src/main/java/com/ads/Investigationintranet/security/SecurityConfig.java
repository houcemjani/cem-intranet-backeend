//package com.ads.Investigationintranet.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Bean
//  protected AuthenticationManager authenticationManager() throws Exception {
//    return new AuthenticationManagerAdapter();
//  }
//
//  @Bean
//  AuthenticationFilter authFilter() {
//    return new AuthenticationFilter();
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//        .cors().and().csrf().disable()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .authorizeRequests()
//        .antMatchers("/authenticate/**").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .addFilterBefore(authFilter(),UsernamePasswordAuthenticationFilter.class);
//  }
//
//
//}
