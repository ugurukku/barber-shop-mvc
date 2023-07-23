package az.millisoft.first.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/admin")
                        .permitAll()
                )
                .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/","/images/**","/css/**","/js/**","/fonts/**","/images/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/reservation").permitAll()
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }

}
