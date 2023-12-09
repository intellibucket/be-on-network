package com.intellibucket.onnetwork.vacancy.container.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.onnetwork.vacancy.presentation.command",
                "com.intellibucket.onnetwork.vacancy.domain.presentation.command",
                "com.intellibucket.onnetwork.vacancy.domain.core.command",
                "com.intellibucket.onnetwork.vacancy.dataAccess.command",
                "com.intellibucket.onnetwork.vacancy.messaging.command"}
)
@ServletComponentScan
public class VacancyCommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(VacancyCommandApplication.class,args);
    }
}