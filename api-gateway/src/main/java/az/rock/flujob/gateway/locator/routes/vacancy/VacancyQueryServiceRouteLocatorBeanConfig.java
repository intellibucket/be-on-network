package az.rock.flujob.gateway.locator.routes.vacancy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VacancyQueryServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.vacancy-query.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.vacancy-query.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.vacancy-query.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.vacancy-query.api.public}")
    private String publicApi;


}
