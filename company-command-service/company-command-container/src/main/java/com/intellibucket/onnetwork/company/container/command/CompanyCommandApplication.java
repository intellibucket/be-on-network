package com.intellibucket.onnetwork.company.container.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.onnetwork.company.presentation.command",
                "com.intellibucket.onnetwork.company.domain.presentation.command",
                "com.intellibucket.onnetwork.company.domain.core.command",
                "com.intellibucket.onnetwork.company.dataAccess.command",
                "com.intellibucket.onnetwork.company.messaging.command"}
)
@ServletComponentScan
@EnableJpaRepositories(basePackages = {"com.intellibucket.onnetwork.company.dataAccess.command"})
@EntityScan(basePackages = {"com.intellibucket.onnetwork.company.dataAccess.command.model.entity"})
public class CompanyCommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyCommandApplication.class, args);
    }
}