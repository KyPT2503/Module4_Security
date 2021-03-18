package com.example.demo_security.config;

import com.example.demo_security.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    *@Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
        memoryUserDetailsManager.createUser(userBuilder.username("thu").password("thu").roles("USER").build());
        memoryUserDetailsManager.createUser(userBuilder.username("admin").password("admin").roles("ADMIN").build());
        return memoryUserDetailsManager;
    }*/

    @Autowired
    private IAppUserService appUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home").permitAll()
                .and()
                .authorizeRequests().antMatchers("/profile").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/manager").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.csrf().disable();
    }
}
