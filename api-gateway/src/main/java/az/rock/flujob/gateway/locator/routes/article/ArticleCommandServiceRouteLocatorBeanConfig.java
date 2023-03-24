package az.rock.flujob.gateway.locator.routes.article;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleCommandServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.article-command.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.article-command.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.article-command.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.article-command.api.public}")
    private String publicApi;


}
