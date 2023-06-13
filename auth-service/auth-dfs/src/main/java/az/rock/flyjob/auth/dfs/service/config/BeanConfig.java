package az.rock.flyjob.auth.dfs.service.config;

import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    public MinioService minioService() {
        return null;
    }
}
