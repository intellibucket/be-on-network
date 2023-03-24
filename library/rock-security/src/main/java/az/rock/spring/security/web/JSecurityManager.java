package az.rock.spring.security.web;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.constant.HeaderConstant;
import az.rock.message.MessageProvider;
import az.rock.spring.security.model.ClaimModel;
import az.rock.spring.security.model.HeaderModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.*;

public class JSecurityManager {
    private final MessageProvider messageProvider;
    private final String encryptKey;
    private final String tokenExpDate;

    public JSecurityManager(MessageProvider messageProvider, String encryptKey, String tokenExpDate) {
        this.messageProvider = messageProvider;
        this.encryptKey = encryptKey;
        this.tokenExpDate = tokenExpDate;
    }


    public HeaderModel checkAndPrepareHeader(ServerHttpRequest serverHttpRequest) throws JSecurityException {

        String ipAddress = Objects.requireNonNull(serverHttpRequest.getRemoteAddress()).getAddress().getHostAddress();
        String lang = Objects.requireNonNullElse(serverHttpRequest.getHeaders().get(HeaderConstant.LANG), List.of("az")).get(0);
        List<String> optionalPrivateKey = serverHttpRequest.getHeaders().get(HeaderConstant.USER_PRIVATE_KEY);
        var token = "";
        if (Objects.isNull(optionalPrivateKey) || optionalPrivateKey.isEmpty())
            throw new JSecurityException(this.messageProvider.fail("F_0000000002", lang));
        if (serverHttpRequest.getHeaders().containsKey(HeaderConstant.AUTHORIZATION)) {
            token = Objects.requireNonNull(serverHttpRequest.getHeaders().get(HeaderConstant.AUTHORIZATION)).get(0).replace(HeaderConstant.BEARER.concat(" "), "");
        } else throw new JSecurityException(this.messageProvider.fail("F_0000000002", lang));
        return HeaderModel
                .builder()
                .withLang(lang)
                .withIpAddress(ipAddress)
                .withUserRequestPrivateKey(optionalPrivateKey.get(0))
                .withToken(token)
                .build();
    }


    public boolean isValidToken(HeaderModel headerModel, ClaimModel claimModel) throws JSecurityException {
        String unauthorizedMessage = this.messageProvider.fail("F_0000000002", headerModel.getLang());
        try {
            return claimModel.getUserUUID() != null &&
                    claimModel.getRoleNames() != null &&
                    !claimModel.getRoleNames().isEmpty() &&
                    claimModel.getPermissions() != null &&
                    !claimModel.getPermissions().isEmpty() &&
                    claimModel.getIpAddress().equals(headerModel.getIpAddress()) &&
                    claimModel.getUserPrivateKey().equals(headerModel.getUserRequestPrivateKey());
        } catch (MalformedJwtException malformedJwtException) {
            throw new JSecurityException(unauthorizedMessage);
        }
    }


    public Claims getClaims(HeaderModel headerModel) throws JSecurityException {
        try {
            return Jwts.parser()
                    .setSigningKey(this.encryptKey.concat(headerModel.getUserRequestPrivateKey()))
                    .parseClaimsJws(headerModel.getToken())
                    .getBody();
        } catch (Exception exception) {
            throw new JSecurityException("Invalid Token");
        }
    }

    public boolean compare(ClaimModel claimModel, HeaderModel headerModel) {
        return claimModel.getUserPrivateKey().equals(headerModel.getUserRequestPrivateKey()) &&
                claimModel.getIpAddress().equals(headerModel.getIpAddress());
    }


    public void checkExpirationDate(Claims claims) throws JSecurityException {
        var expiredDate = claims.getExpiration();
        var now = new Date();
        if (now.after(expiredDate)) throw new JSecurityException("Token is expired");
    }

    public String generateToken(Map<String, Object> claims,
                                String headerPrivateKey) {
        Claims varClaims = Jwts.claims(claims);
        varClaims.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(this.tokenExpDate)));
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, this.encryptKey.concat(headerPrivateKey))
                .setClaims(varClaims)
                .compact();
    }


    public Map<String, String> prepareDetail(JUserDetail userDetail) {
        HashMap<String, String> map = new HashMap<>();
        map.put(HeaderConstant.UUID, userDetail.getUserUUID());
        map.put(HeaderConstant.USERNAME, userDetail.getUsername());
        return map;
    }
}
