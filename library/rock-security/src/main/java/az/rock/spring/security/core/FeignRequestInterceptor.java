package az.rock.spring.security.core;

import az.rock.lib.util.constant.HeaderConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignRequestInterceptor implements RequestInterceptor {
    private final String feignToken;

    public FeignRequestInterceptor(String feignToken) {
        this.feignToken = feignToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header(HeaderConstant.FEIGN, feignToken);
    }
}