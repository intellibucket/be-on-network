package az.rock.flyjob.auth.dataAccess.config.jooq;

import az.rock.flyjob.auth.dataAccess.exception.AuthDataAccessException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class JOOQConnector {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    private Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new AuthDataAccessException(e.getMessage());
        }
        return connection;
    }

    @Bean
    public DSLContext dslContext(){
        return DSL.using(this.connection(), SQLDialect.POSTGRES);
    }
}
