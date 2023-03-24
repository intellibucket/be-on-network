package az.rock.flujob.gateway.locator.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployerServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.employer.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.employer.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.employer.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.employer.api.public}")
    private String publicApi;

}
