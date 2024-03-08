package com.intellibucket.lib.client.model.response;

import java.util.List;
import java.util.UUID;

public class AuthorizationMetaData {
    private UUID userId;
    private String userName;
    private String userRole;
    private List<String> permissions;
    private Boolean isAvailable;

    public AuthorizationMetaData() {}

    public AuthorizationMetaData(Builder builder) {
        setUserId(builder.userId);
        setUserName(builder.userName);
        setUserRole(builder.userRole);
        setPermissions(builder.permissions);
        setAvailable(builder.isAvailable);
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public static final class Builder {
        private UUID userId;
        private String userName;
        private String userRole;
        private List<String> permissions;
        private Boolean isAvailable;

        public Builder() {
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder userRole(String val) {
            userRole = val;
            return this;
        }

        public Builder permissions(List<String> val) {
            permissions = val;
            return this;
        }

        public Builder isAvailable(Boolean val) {
            isAvailable = val;
            return this;
        }

        public AuthorizationMetaData build() {
            return new AuthorizationMetaData(this);
        }
    }
}
