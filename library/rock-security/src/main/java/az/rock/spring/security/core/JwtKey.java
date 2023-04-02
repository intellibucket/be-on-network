package az.rock.spring.security.core;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class JwtKey {
    public KeyGenerator of() throws NoSuchAlgorithmException {
        var generator = KeyGenerator.getInstance("AES");
        generator.init(512);
        return generator;
    }

    public SecretKey generateKey(String secretKey) {
        return new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HS512");
    }
}
