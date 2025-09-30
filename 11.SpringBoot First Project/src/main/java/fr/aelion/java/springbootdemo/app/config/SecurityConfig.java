package fr.aelion.java.springbootdemo.app.config;

import fr.aelion.java.springbootdemo.app.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

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
            .cors(Customizer.withDefaults()) // <- enable CORS using the bean below
            .authorizeHttpRequests(filter -> {
            filter
                .requestMatchers("/api/v1/demo/**").permitAll() // public
                .requestMatchers("/api/v1/auth/**").permitAll() // public
                .requestMatchers("/api/v1/admin/**").hasAnyRole("ADMIN") // spec. authorization
                .anyRequest().authenticated(); // private
            });

        return http.build();

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of("http://localhost:4200")); // exact origin, not "*"
        cfg.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        cfg.setAllowedHeaders(List.of("Authorization","Content-Type","X-Requested-With"));
        cfg.setExposedHeaders(List.of("Authorization","Location")); // if you need to read them client-side
        cfg.setAllowCredentials(true); // only if you use cookies/session
        cfg.setMaxAge(3600L); // cache preflight 1h

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
