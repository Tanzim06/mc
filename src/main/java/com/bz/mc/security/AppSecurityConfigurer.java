package com.bz.mc.security;



import com.bz.mc.repository.UserRepository;
import com.bz.mc.service.CustomUserDetailsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
@Configuration
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @NonNull private final CustomUserDetailsService userDetailsService;
    @NonNull private final PermissionDeniedExceptionHandler permissionDeniedExceptionHandler;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/about", "/assets/**", "/images/**", "/error/**", "/api/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(permissionDeniedExceptionHandler);
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
