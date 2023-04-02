package az.rock.spring.security.model;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.constant.ClaimConstant;
import io.jsonwebtoken.Claims;

import java.util.Objects;
import java.util.Set;

public class ClaimTaker {
    private final Claims claims;

    private ClaimTaker(Claims claims) {
        this.claims = claims;
    }

    public static ClaimTaker of(Claims claims) {
        return new ClaimTaker(claims);
    }

    public Claims getClaims() {
        return this.claims;
    }

    public String getUUID() {
        return (String) Objects.requireNonNull(
                claims.get(ClaimConstant.UUID), () -> {
                    throw new JSecurityException();
                }
        );
    }

    public String getUserPrivateKey() {
        return (String) Objects.requireNonNull(
                claims.get(ClaimConstant.USER_PRIVATE_KEY), () -> {
                    throw new JSecurityException();
                }
        );
    }

    public String getUsername() {
        return (String) Objects.requireNonNull(
                claims.get(ClaimConstant.USERNAME), () -> {
                    throw new JSecurityException();
                }
        );
    }


    public String getIpAddress() {
        return (String) Objects.requireNonNull(
                claims.get(ClaimConstant.IP_ADDRESS), () -> {
                    throw new JSecurityException();
                }
        );
    }

    @SuppressWarnings("unchecked")
    public Set<String> getPermissions() {
        return (Set<String>) Objects.requireNonNull(
                claims.get(ClaimConstant.PERMISSIONS), () -> {
                    throw new JSecurityException();
                }
        );
    }

    @SuppressWarnings("unchecked")
    public Set<String> getRoles() {
        return (Set<String>) Objects.requireNonNull(
                claims.get(ClaimConstant.ROLE), () -> {
                    throw new JSecurityException();
                }
        );
    }
}
