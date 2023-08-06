package com.hadit1993.admin.dashboard.spring.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${client.baseurl}")
    private String clientUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(clientUrl)
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);

      WebMvcConfigurer.super.addCorsMappings(registry);
    }


//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource {
//        val configuration = CorsConfiguration().apply {
//            allowedOrigins = listOf(clientUrl)
//            allowedMethods = listOf("*")
//            allowedHeaders = listOf("*")
//            allowCredentials = true
//            maxAge = 3600L
//        }
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }


}
