package az.rock.flujob.gateway.locator.filter.concretes;

import az.rock.flujob.gateway.locator.filter.abstracts.AbstractGAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GAuthorizationFilter extends AbstractGAuthorizationFilter {
    @Override
    public GatewayFilter apply(Config config) {
        log.debug("Api Gateway authorization filter executed");
        return ((exchange, chain) -> chain.filter(exchange));
    }
}
