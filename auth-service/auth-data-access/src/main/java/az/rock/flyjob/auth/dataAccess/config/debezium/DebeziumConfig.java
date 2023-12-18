package az.rock.flyjob.auth.dataAccess.config.debezium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;

@Configuration
public class DebeziumConfig {


    @Bean
    public io.debezium.config.Configuration customerConnector(Environment env) throws IOException {
        var offsetStorageTempFile = File.createTempFile("offsets_", ".dat");
        return io.debezium.config.Configuration.create()
                .with("name", "customer_postgres_connector")
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
                .with("offset.flush.interval.ms", "60000")
                .with("database.hostname", "62.72.45.66")
                .with("database.port", "4445")
                .with("database.user", "postgres")
                .with("database.password", "123456")
                .with("database.dbname", "auth_db")
                .with("database.server.id", "10181")
                .with("database.server.name", "auth-postgres-db-server")
                .with("database.history", "io.debezium.relational.history.MemoryDatabaseHistory")
                .with("table.include.list", "auth.users")
                //.with("column.include.list", "public.customer.email,public.customer.fullname")
                //.with("publication.autocreate.mode", "filtered")
                .with("plugin.name", "pgoutput")
                .with("slot.name", "dbz_customerdb_listener")
                .build();
    }
}
