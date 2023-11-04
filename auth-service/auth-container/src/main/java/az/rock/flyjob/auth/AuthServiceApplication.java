package az.rock.flyjob.auth;


import org.jooq.codegen.GenerationTool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.nio.file.Files;
import java.nio.file.Path;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "az.rock.flyjob.auth",
                "az.rock.auth.domain.presentation",
                "az.rock.flyjob.auth.dataAccess",
                "az.rock.flyjob.auth.messaging",
                "az.rock.flyjob.auth.config",
                "az.rock.flyjob.auth.dfs"},
        scanBasePackageClasses = {
                az.rock.flyjob.auth.config.PresentationBeanConfig.class
        })
@ServletComponentScan
@MapperScan(value = {"az/rock/flyjob/auth/dataAccess/repository/abstracts/query/batis"})
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
