package com.intellibucket.flyjob.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.flyjob.vacancy.presentation",
                "com.intellibucket.flyjob.vacancy.domain.presentation",
                "com.intellibucket.flyjob.vacancy.domain.core",
                "com.intellibucket.flyjob.vacancy.dataAccess",
                "com.intellibucket.flyjob.vacancy.messaging"})
@ServletComponentScan
public class VacancyCommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(VacancyCommandApplication.class,args);
    }
}