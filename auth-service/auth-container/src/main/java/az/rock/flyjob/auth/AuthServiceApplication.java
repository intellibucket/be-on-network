package az.rock.flyjob.auth;


import az.rock.flyjob.auth.dataAccess.entity.DataAccessBeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {},
        scanBasePackageClasses = {
                az.rock.flyjob.auth.config.PresentationBeanConfig.class
                , DataAccessBeanConfig.class
        })
@ServletComponentScan
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
