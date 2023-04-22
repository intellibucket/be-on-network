package az.rock.flyjob.gateway.locator.routes;

import az.rock.flyjob.gateway.locator.filter.concretes.GFeignApiFilter;
import az.rock.flyjob.gateway.locator.filter.concretes.GIdentityFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationServiceRouteLocatorBeanConfig {

    @Value(value = "${ws.values.locator.service.authorization.name}")
    private String serviceName;

    @Value(value = "${ws.values.locator.service.authorization.api.feign}")
    private String feignApi;

    @Bean
    public RouteLocator authorizationFeignLocator(RouteLocatorBuilder routeLocatorBuilder, GFeignApiFilter feignApiFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.feignApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                .filter(feignApiFilter.apply(new GIdentityFilter.Config()))
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }

}
