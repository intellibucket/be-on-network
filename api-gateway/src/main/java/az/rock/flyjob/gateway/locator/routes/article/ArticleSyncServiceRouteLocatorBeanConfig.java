package az.rock.flyjob.gateway.locator.routes.article;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleSyncServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.article-sync.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.article-sync.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.article-sync.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.article-sync.api.public}")
    private String publicApi;


}
