package az.rock.flyjob.gateway.locator.routes;

import az.rock.flyjob.gateway.locator.filter.concretes.GAuthorizationFilter;
import az.rock.flyjob.gateway.locator.filter.concretes.GFeignApiFilter;
import az.rock.flyjob.gateway.locator.filter.concretes.GPublicApiFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
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


    @Bean
    public RouteLocator authPrivateLocator(RouteLocatorBuilder routeLocatorBuilder, GAuthorizationFilter
            authorizationHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.privateApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                .filter(authorizationHeaderFilter.apply(new GAuthorizationFilter.Config()))
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }

    @Bean
    public RouteLocator authPublicLocator(RouteLocatorBuilder routeLocatorBuilder, GPublicApiFilter commonFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.publicApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                .filter(commonFilter.apply(new GPublicApiFilter.Config()))
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }

    @Bean
    public RouteLocator authFeignLocator(RouteLocatorBuilder routeLocatorBuilder, GFeignApiFilter feignApiFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.feignApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                .filter(feignApiFilter.apply(new GFeignApiFilter.Config()))
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }

}
