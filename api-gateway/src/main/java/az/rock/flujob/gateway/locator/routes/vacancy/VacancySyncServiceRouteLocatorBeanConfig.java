package az.rock.flujob.gateway.locator.routes.vacancy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VacancySyncServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.vacancy-sync.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.vacancy-sync.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.vacancy-sync.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.vacancy-sync.api.public}")
    private String publicApi;


}
