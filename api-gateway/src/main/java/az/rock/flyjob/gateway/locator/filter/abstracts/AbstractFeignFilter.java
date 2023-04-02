package az.rock.flyjob.gateway.locator.filter.abstracts;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public abstract class AbstractFeignFilter
        extends AbstractGatewayFilterFactory<AbstractFeignFilter.Config> {
    public static class Config {
    }
}
