package org.miralles.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ResumeServiceApplication {

    private static final String CORS_IP = "CORS_IP";

    private final Environment env;

    public ResumeServiceApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResumeServiceApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                String corsIp = env.getProperty(CORS_IP);

                registry.addMapping("/education/*")
                        .allowedOrigins(corsIp);
                registry.addMapping("/contactInfo")
                        .allowedOrigins(corsIp);
                registry.addMapping("/experience/*")
                        .allowedOrigins(corsIp);
                registry.addMapping("/skill/*")
                        .allowedOrigins(corsIp);
            }
        };
    }

}
