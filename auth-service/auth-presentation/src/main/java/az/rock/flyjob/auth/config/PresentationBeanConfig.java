package az.rock.flyjob.auth.config;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.factory.JSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentationBeanConfig {

    @Bean
    public AbstractJSuccessResponseFactory<? super JSuccessDataResponse<?>> jSuccessResponseFactory() {
        return new JSuccessResponseFactory<>();
    }
}
