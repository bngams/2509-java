package fr.aelion.java.springbootdemo.app.config;

import fr.aelion.java.springbootdemo.app.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // ANALYZE HEADERS (check for Authorization TOKEN ...)
            .addFilterAfter((servletRequest, servletResponse, filterChain) -> {
                HttpServletRequest hsr = (HttpServletRequest) servletRequest;
                String authHeaderValue = hsr.getHeader("Authorization");
                if(authHeaderValue != null && !authHeaderValue.isEmpty()) {
                    // tokenValue should be something like : Bearer XYZNtghnjk...
                    String tokenValue = authHeaderValue.replace("Bearer ", "");
                    if(!tokenValue.isEmpty() && TokenUtils.checkRandomFakeToken(tokenValue)) {
                        // TODO: traitement JWT (JWT decode...expiration)
                        // generate Spring Secu Auth
                        SecurityContextHolder.getContext().setAuthentication(
                                UsernamePasswordAuthenticationToken.authenticated("email", tokenValue, null)
                        );
                    }
                }
                // do next filter
                filterChain.doFilter(servletRequest, servletResponse);
            }, UsernamePasswordAuthenticationFilter.class)
            // DEFINE ACCESS, PERMISSIONS.... (routes config.)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(filter -> {
                filter
                    .requestMatchers("/api/v1/demo/**").permitAll() // public
                    .requestMatchers("/api/v1/auth/**").permitAll() // public
                    .requestMatchers("/api/v1/admin/**").hasAnyRole("ADMIN") // spec. authorization
                    .anyRequest().authenticated(); // private
            });

        return http.build();

    }
}
