package az.rock.flyjob.gateway.locator.routes.article;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleQueryServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.article-query.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.article-query.api.feign}")
    private String feignApi;

    @Value(value = "${ws.values.locator.service.article-query.api.private}")
    private String privateApi;

    @Value(value = "${ws.values.locator.service.article-query.api.public}")
    private String publicApi;


}
