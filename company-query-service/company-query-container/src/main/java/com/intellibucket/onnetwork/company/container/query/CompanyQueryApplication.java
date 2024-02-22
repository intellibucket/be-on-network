package com.intellibucket.onnetwork.company.container.query;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.onnetwork.company.presentation.query",
                "com.intellibucket.onnetwork.company.domain.presentation.command",
                "com.intellibucket.onnetwork.company.domain.core.command",
                "com.intellibucket.onnetwork.company.dataAccess.command",
                "com.intellibucket.onnetwork.company.messaging.command"}
)
public class CompanyQueryApplication {
    public static void main(String[] args) {

    }
}
