package com.intellibucket.lib.client.model.request;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AuthorizationRequestModel {
    private UUID transactionId;
    private ZonedDateTime timestamp;
    private String publicKey;
    private String token;

    public AuthorizationRequestModel() {}

    public AuthorizationRequestModel(UUID transactionId,ZonedDateTime timestamp, String publicKey, String token) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.publicKey = publicKey;
        this.token = token;
    }

    private AuthorizationRequestModel(Builder builder) {
        setTransactionId(builder.transactionId);
        setTimestamp(builder.timestamp);
        setPublicKey(builder.publicKey);
        setToken(builder.token);
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getToken() {
        return token;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public static final class Builder {
        private UUID transactionId;
        private ZonedDateTime timestamp;
        private String publicKey;
        private String token;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder transactionId(UUID val) {
            transactionId = val;
            return this;
        }

        public Builder timestamp(ZonedDateTime val) {
            timestamp = val;
            return this;
        }

        public Builder publicKey(String val) {
            publicKey = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public AuthorizationRequestModel build() {
            return new AuthorizationRequestModel(this);
        }
    }
}
