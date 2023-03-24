package az.rock.flujob.gateway.locator.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobSeekerServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.job-seeker.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.job-seeker.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.job-seeker.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.job-seeker.api.public}")
    private String publicApi;

}
