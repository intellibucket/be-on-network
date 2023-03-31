package az.rock.spring.security.core;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CustomFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("X-Feign-Header", "skfasdf443fsksksd");
    }
}