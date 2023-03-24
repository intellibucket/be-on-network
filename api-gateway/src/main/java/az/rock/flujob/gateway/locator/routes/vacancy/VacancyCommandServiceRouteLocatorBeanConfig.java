package az.rock.flujob.gateway.locator.routes.vacancy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VacancyCommandServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.vacancy-command.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.vacancy-command.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.vacancy-command.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.vacancy-command.api.public}")
    private String publicApi;


}
