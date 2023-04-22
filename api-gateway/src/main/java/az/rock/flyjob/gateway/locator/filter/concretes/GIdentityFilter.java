package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractFeignFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;

public class GIdentityFilter extends AbstractFeignFilter {
    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }
}
