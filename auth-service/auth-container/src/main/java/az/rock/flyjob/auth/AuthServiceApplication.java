package az.rock.flyjob.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "az.rock.flyjob.auth.api.rest",
                "az.rock.auth.domain.presentation",
                "az.rock.flyjob.auth.dataAccess",
                "az.rock.flyjob.auth.messaging",
                "az.rock.flyjob.auth.config",
                "az.rock.flyjob.auth.dfs",},
        scanBasePackageClasses = {
                az.rock.flyjob.auth.config.PresentationBeanConfig.class
        })
@ServletComponentScan
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }


}
