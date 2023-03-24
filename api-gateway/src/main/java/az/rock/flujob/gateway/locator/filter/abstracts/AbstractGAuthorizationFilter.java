package az.rock.flujob.gateway.locator.filter.abstracts;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public abstract class AbstractGAuthorizationFilter
        extends AbstractGatewayFilterFactory<AbstractGAuthorizationFilter.Config> {
    public static class Config {
    }
}
