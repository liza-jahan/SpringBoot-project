package com.example.springprojectsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("liza")
                .password(passwordEncoder().encode("liza1"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("miraj")
                .password(passwordEncoder().encode("miraj1"))
                .roles("ADMIN").authorities("ACCESS_TEST1","ACCESS_TEST2","ROLE_ADMIN")
                .build();

        UserDetails user3= User.builder()
                .username("niha")
                .password(passwordEncoder().encode("niha1"))
                .roles("MANAGER").authorities("ACCESS_TEST1","ROLE_MANAGER")
                .build();
        List<UserDetails> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return new InMemoryUserDetailsManager(users);
    }

    /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }*/
   @Bean
   public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   return   http.csrf().disable()

               .authorizeHttpRequests()
            /*   */

               .requestMatchers("/index.html").permitAll()
               .requestMatchers("/profile/index.html").authenticated()
               .requestMatchers("/admin/index.html").hasRole("ADMIN")
               .requestMatchers("/management/index.html").hasAnyRole("ADMIN", "MANAGER")
               .requestMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
               .requestMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
           /*    .requestMatchers("/api/public/users").hasRole("ADMIN")*/

               .anyRequest().permitAll()

           .and().formLogin()
               .and().build();

   }
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin12")).roles("ADMIN")
                .and()
                .withUser("liza").password(passwordEncoder().encode("liza12")).roles("USER");
    }*/

    @Bean
  PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
