package az.rock.flyjob.auth.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    private String minioUrl = "http://localhost:9000";
    private String miniobucket = "auth-bucket";
    private String accessKey = "Hzrrn6bhdoKl5rT33NVU";
    private String secretKey = "yV8pLtcGIpDQ4tkaa91OlV11EKJvX8XzSBvst87l";

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(this.minioUrl)
                .credentials(this.accessKey, this.secretKey)
                .build();
    }

    public String getMiniobucket() {
        return miniobucket;
    }
}
