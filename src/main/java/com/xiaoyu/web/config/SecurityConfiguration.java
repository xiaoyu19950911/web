package com.xiaoyu.web.config;

import com.xiaoyu.web.repository.UserRepository;
import com.xiaoyu.web.security.transition.TransitionUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/23 10:52
 * @Modified By:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new TransitionUserServiceImpl();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.
                authorizeRequests()
                .antMatchers("/oauth/**","/auth/regist","/learn/login").permitAll()
                .antMatchers(
                        "/","/*.jpg","/*.png","/*.svg",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js","/static/img/*.jpg"
                ).permitAll()
                .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/").defaultSuccessUrl("/learn/touristsLogin").failureForwardUrl("/learn/redirect/404").loginProcessingUrl("/j_spring_security_check").permitAll()
        .and()
        .httpBasic();
       /* http.requestMatchers().anyRequest()
                .and().authorizeRequests().antMatchers("/oauth/**").permitAll();*/
      /* http.requestMatchers().antMatchers("/oauth/**")
               .and()
               .authorizeRequests()
               .antMatchers("/oauth/**").authenticated();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
