package az.rock.spring.security.core;

import az.rock.spring.security.model.ClaimModel;
import az.rock.spring.security.model.HeaderModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtService {

    private final JwtConfig jwtConfig;

    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(ClaimModel claimModel, String privateKey) {
        var claims = claimModel.generateMapClaim();
        Claims varClaims = Jwts.claims(claims);
        varClaims.setExpiration(new Date(System.currentTimeMillis() + this.jwtConfig.getExpiration()));
        var encodePrivateKey = Base64.getEncoder().encodeToString(privateKey.getBytes());
        var endKey = this.jwtConfig.getSecret().concat(encodePrivateKey);
        return Jwts.builder()
                .setSubject(claimModel.getUserUUID().toString())
                .signWith(JwtKey.generateKey(endKey), SignatureAlgorithm.HS512)
                .setClaims(varClaims)
                .compact();
    }


    public UUID getUUIDFromToken(String token, String encodePrivateKey) {
        return UUID.fromString(this.getClaims(token, encodePrivateKey).getSubject());
    }

    private Boolean isTokenValid(String token, String encodedPrivateKey) {
        try {
            this.getClaims(token, encodedPrivateKey);
            return !this.isExpired(token, encodedPrivateKey);
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean validateToken(HeaderModel model) {
        var claimModel = ClaimModel.of(this.getClaims(model.getToken(), model.getEncodedUserRequestPrivateKey()));
        return this.isTokenValid(model.getToken(), model.getEncodedUserRequestPrivateKey()) &&
                !claimModel.isEmpty() &&
                this.isEquals(model, claimModel);
    }

    private Boolean isExpired(String token, String encodedPrivateKey) {
        var expiredDate = this.getClaims(token, encodedPrivateKey).getExpiration();
        return new Date().after(expiredDate);
    }

    public Claims getClaims(String token, String encodedPrivateKey) {
        return Jwts.parserBuilder()
                .setSigningKey(this.jwtConfig.getSecret().concat(encodedPrivateKey).getBytes(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    private Boolean isEquals(HeaderModel headerModel, ClaimModel claimModel) {
        return claimModel.getUserPrivateKey().equals(headerModel.getEncodedUserRequestPrivateKey()) &&
                claimModel.getIpAddress().equals(headerModel.getIpAddress());
    }
}
