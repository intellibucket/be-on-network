package az.rock.spring.security.model;

import az.rock.lib.util.constant.HeaderConstant;
import io.jsonwebtoken.Claims;

import java.util.*;

public class ClaimModel {

    private UUID userUUID;

    private String username;

    private String userPrivateKey;

    private String ipAddress;

    private Set<String> roleNames;

    private Set<String> permissions;

    public ClaimModel() {
    }

    private ClaimModel(Builder builder) {
        userUUID = builder.userUUID;
        username = builder.username;
        userPrivateKey = builder.userPrivateKey;
        ipAddress = builder.ipAddress;
        roleNames = builder.roleNames;
        permissions = builder.permissions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID userUUID;
        private String username;
        private String userPrivateKey;
        private String ipAddress;
        private Set<String> roleNames;
        private Set<String> permissions;

        private Builder() {
        }

        public Builder withUserUUID(UUID userUUID) {
            this.userUUID = userUUID;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withUserPrivateKey(String userPrivateKey) {
            this.userPrivateKey = userPrivateKey;
            return this;
        }

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withRoleNames(Set<String> roleNames) {
            this.roleNames = roleNames;
            return this;
        }

        public Builder withRoleName(String roleName) {
            this.roleNames = Set.of(roleName);
            return this;
        }

        public Builder withPermissions(Set<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        public ClaimModel build() {
            return new ClaimModel(this);
        }
    }

    public Map<String, Object> generateMapClaim() {
        Map<String, Object> claims = new HashMap<>();
        claims.put(HeaderConstant.UUID, this.userUUID);
        claims.put(HeaderConstant.USERNAME, this.username);
        claims.put(HeaderConstant.USER_PRIVATE_KEY, this.userPrivateKey);
        claims.put(HeaderConstant.ROLE, this.roleNames);
        claims.put(HeaderConstant.PERMISSIONS, this.permissions);
        claims.put(HeaderConstant.IP_ADDRESS, this.ipAddress);
        return claims;
    }

    public static ClaimModel buildModel(HeaderModel headerModel,
                                        UUID userUUID,
                                        String username,
                                        Set<String> permissions,
                                        Set<String> roleNames) {
        return ClaimModel.builder()
                .withUserUUID(userUUID)
                .withUserPrivateKey(headerModel.getUserRequestPrivateKey())
                .withUsername(username)
                .withIpAddress(headerModel.getIpAddress())
                .withPermissions(permissions)
                .withRoleNames(roleNames)
                .build();
    }

    @SuppressWarnings("unchecked")
    public static ClaimModel of(Claims claims) {
        return ClaimModel
                .builder()
                .withUserUUID(UUID.fromString((String) claims.get(HeaderConstant.UUID)))
                .withRoleNames(new HashSet<>((ArrayList<String>) claims.get(HeaderConstant.ROLE)))
                .withPermissions(new HashSet<>((ArrayList<String>) claims.get(HeaderConstant.PERMISSIONS)))
                .withUsername((String) claims.get(HeaderConstant.USERNAME))
                .withIpAddress((String) claims.get(HeaderConstant.IP_ADDRESS))
                .withUserPrivateKey((String) claims.get(HeaderConstant.USER_PRIVATE_KEY))
                .build();
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPrivateKey() {
        return userPrivateKey;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public Set<String> getPermissions() {
        return permissions;
    }


    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPrivateKey(String userPrivateKey) {
        this.userPrivateKey = userPrivateKey;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
