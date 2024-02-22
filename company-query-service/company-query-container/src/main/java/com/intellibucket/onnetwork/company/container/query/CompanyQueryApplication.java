package com.intellibucket.onnetwork.company.container.query;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.onnetwork.company.spec.query",
                "com.intellibucket.onnetwork.company.presentation.query",
                "com.intellibucket.onnetwork.company.dataaccess.query",
                "com.intellibucket.onnetwork.company.query.domain.presentation",
                "com.intellibucket.onnetwork.company.query.messaging"
        }
)
@ServletComponentScan
@EntityScan(basePackages = {"com.intellibucket.onnetwork.company.dataaccess.query"})
public class CompanyQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyQueryApplication.class, args);
    }
}
