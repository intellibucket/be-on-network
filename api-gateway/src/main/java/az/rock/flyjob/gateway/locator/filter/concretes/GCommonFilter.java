package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractGCommonFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GCommonFilter extends AbstractGCommonFilter {
    @Override
    public GatewayFilter apply(Config config) {
        log.debug("Api Gateway common filter executed");
        return ((exchange, chain) -> chain.filter(exchange));
    }
}
