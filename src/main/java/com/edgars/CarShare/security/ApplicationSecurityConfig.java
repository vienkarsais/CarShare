package com.edgars.CarShare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    public final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()*/
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/signup", "/index", "/css/*", "js/*", "/add-user").permitAll()
                .antMatchers("/car/**").hasRole(UserRoles.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/index")
                    .permitAll()
                    .defaultSuccessUrl("/car/car-list", true)
                    .usernameParameter("email")
                    .passwordParameter("password")
                .and()
                .rememberMe()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) //delete after enable csrf
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/index");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                //.roles(UserRoles.ADMIN.name()) //ROLE_ADMIN
                .authorities(UserRoles.ADMIN.getGrantedAuthorities())
                .build();

        UserDetails userTest = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                //.roles(UserRoles.USER.name()) //ROLE_USER
                .authorities(UserRoles.USER.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(admin, userTest);
    }
}
