package com.company.service;

import com.company.service.service.StartAppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(ServiceApplication.class, args);
        context.getBean(StartAppService.class).startApp();
    }
}
