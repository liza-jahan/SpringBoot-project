package net.codeJava;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/users").authenticated()
	 * .anyRequest().permitAll() .and() .formLogin() .usernameParameter("email")
	 * .defaultSuccessUrl("/users") .permitAll() .and()
	 * .logout().logoutSuccessUrl("/").permitAll(); }
	 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
        		
                .authorizeHttpRequests()
                .requestMatchers("/list_users") 
                .authenticated() .anyRequest().permitAll()
                .and()
               .formLogin().usernameParameter("email").defaultSuccessUrl("/list_users").permitAll()
               .and().logout().logoutSuccessUrl("/").permitAll().and().build();
        		
    }
}

