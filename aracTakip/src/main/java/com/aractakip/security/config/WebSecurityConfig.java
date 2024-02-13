package com.aractakip.security.config;
import com.aractakip.security.jwt.AuthEntryPointJwt;
import com.aractakip.security.jwt.AuthTokenFilter;
import com.aractakip.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

   private final UserDetailsServiceImpl userDetailsService;
   private final AuthEntryPointJwt authEntryPointJwt;

   @org.springframework.context.annotation.Bean
   public org.springframework.security.authentication.AuthenticationManager authenticationManager(org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration configuration) throws Exception {
      return configuration.getAuthenticationManager();
   }

   @org.springframework.context.annotation.Bean
   public org.springframework.security.web.SecurityFilterChain filterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
      http.cors().and()
            .csrf().disable()
            .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
            .sessionManagement().sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers(AUTH_WHITE_LIST).permitAll()
            .anyRequest().authenticated();
      http.headers().frameOptions().sameOrigin();
      http.authenticationProvider(authenticationProvider());
      http.addFilterBefore(authenticationJwtTokenFilter(), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

      return http.build();
   }

   @org.springframework.context.annotation.Bean
   public AuthTokenFilter authenticationJwtTokenFilter(){
      return new AuthTokenFilter();
   }

   @org.springframework.context.annotation.Bean
   public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder(){
      return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
   }

   @org.springframework.context.annotation.Bean
   public org.springframework.security.authentication.dao.DaoAuthenticationProvider authenticationProvider(){
      org.springframework.security.authentication.dao.DaoAuthenticationProvider authenticationProvider = new org.springframework.security.authentication.dao.DaoAuthenticationProvider();
      authenticationProvider.setUserDetailsService(userDetailsService);
      authenticationProvider.setPasswordEncoder(passwordEncoder());
      return authenticationProvider;
   }

   @org.springframework.context.annotation.Bean
   public org.springframework.web.servlet.config.annotation.WebMvcConfigurer corsConfigurer(){

      return new org.springframework.web.servlet.config.annotation.WebMvcConfigurer() {
         @Override
         public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {

            registry.addMapping("/**")
                  .allowedOrigins("*")
                  .allowedHeaders("*")
                  .allowedMethods("*");
         }
      };

   }

   private static final String[] AUTH_WHITE_LIST = {
         "/v3/api-docs/**",
         "swagger-ui.html",
         "/swagger-ui/**",
         "/",
         "/index.html",
         "/images/**",
         "/css/**",
         "/js/**",
         "/auth/login"
   };

}
