package az.rock.spring.security.core;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.GObjects;
import az.rock.spring.security.model.HeaderModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JwtService {

    private final JwtConfig jwtConfig;

    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Map<String, Object> claims, String encodePrivateKey) {
        Claims varClaims = Jwts.claims(claims);
        varClaims.setExpiration(new Date(System.currentTimeMillis() + this.jwtConfig.getExpiration()));
        var singKey = this.jwtConfig.getSecret().concat(encodePrivateKey);
        JwtKey key = new JwtKey();
        return Jwts.builder()
                .signWith(key.generateKey(this.jwtConfig.getSecret().concat(encodePrivateKey)), SignatureAlgorithm.HS512)
                .setClaims(varClaims)
                .compact();
    }


    public UUID getUUIDFromToken(String token, String encodePrivateKey) {
        var result = Jwts.parserBuilder()
                .setSigningKey(this.jwtConfig.getSecret().concat(encodePrivateKey).getBytes(StandardCharsets.UTF_8))
                .build();

        return UUID.fromString(Jwts.parserBuilder()
                .setSigningKey(jwtConfig.getSecret().concat(encodePrivateKey).getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    private Boolean isTokenValid(String token, String decodePrivateKey) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret().concat(decodePrivateKey))
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void validateToken(HeaderModel model, JSecurityException exception) {
        GObjects.checkCondition(this.isTokenValid(model.getToken(), model.getEncodedUserRequestPrivateKey()), exception);
        GObjects.checkCondition(!this.isExpired(model.getToken(), model.getEncodedUserRequestPrivateKey()), exception);

    }

    private Boolean isExpired(String token, String encodedPrivateKey) {
        Key key = null;
        var expiredDate = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().concat(encodedPrivateKey))
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        var now = new Date();
        return now.after(expiredDate);
    }

    public Claims getClaims(String token, String encodedPrivateKey) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().concat(encodedPrivateKey))
                .parseClaimsJws(token)
                .getBody();
    }
}
