package com.example.springEducation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example")
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:MathForProgramming.properties")
@PropertySource("classpath:FunDeepLearning.properties")
public class AppConfig {
}
