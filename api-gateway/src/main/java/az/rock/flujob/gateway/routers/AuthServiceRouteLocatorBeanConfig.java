package az.rock.flujob.gateway.routers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthServiceRouteLocatorBeanConfig {

    @Value(value = "${az.rock.ws.values.locator.service-names.auth-service}")
    private String serviceName;

    @Value(value = "${az.rock.ws.values.locator.api.auth.private}")
    private String privateApi;

    @Value(value = "${az.rock.ws.values.locator.api.auth.public}")
    private String publicApi;


}
