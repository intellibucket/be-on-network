package az.rock.flujob.gateway.routers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service-names.auth}")
    private String serviceName;

    @Value(value = "${ws.values.locator.api.auth.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.api.auth.public}")
    private String publicApi;


}
