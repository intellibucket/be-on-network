package az.rock.flyjob.gateway.locator.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.auth.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.auth.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.auth.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.auth.api.public}")
    private String publicApi;


}
