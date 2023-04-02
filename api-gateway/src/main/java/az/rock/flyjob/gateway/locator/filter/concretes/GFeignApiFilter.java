package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractFeignFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GFeignApiFilter extends AbstractFeignFilter {
    @Override
    public GatewayFilter apply(Config config) {
        log.debug("Api Gateway feign filter executed");
        return ((exchange, chain) -> chain.filter(exchange));
    }
}
