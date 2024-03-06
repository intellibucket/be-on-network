package az.rock.flyjob.auth.dataAccess.config.jooq;

import org.jooq.codegen.GenerationTool;

import java.nio.file.Files;
import java.nio.file.Path;

public class JOOQGenerator {
    public static void main(String[] args) throws Exception {
        GenerationTool.generate(
                Files.readString(
                        Path.of("auth-service/auth-data-access/src/main/resources/jooq/jooq-config.xml")
                )
        );
    }
}
