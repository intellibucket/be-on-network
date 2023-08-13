package az.rock.flyjob.js;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "az.rock.flyjob.js.presentation",
                "az.rock.flyjob.js.spec",
                "az.rock.flyjob.js.dataaccess",
                "az.rock.flyjob.js.dfs",
                "az.rock.flyjob.js.domain.core",
                "az.rock.flyjob.js.domain.presentation",
                "az.rock.flyjob.js.messaging"})
@ServletComponentScan
public class JobSeekerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobSeekerApplication.class,args);
    }
}