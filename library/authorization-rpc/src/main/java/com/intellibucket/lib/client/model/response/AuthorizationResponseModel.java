package com.intellibucket.lib.client.model.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AuthorizationResponseModel {
    private UUID transactionId;
    private ZonedDateTime timestamp;
    private Boolean success;
    private String message;
    private AuthorizationMetaData metaData;

    public AuthorizationResponseModel() {
    }

    public AuthorizationResponseModel(UUID transactionId,ZonedDateTime timestamp, Boolean success, String message, AuthorizationMetaData metaData) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.success = success;
        this.message = message;
        this.metaData = metaData;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthorizationMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(AuthorizationMetaData metaData) {
        this.metaData = metaData;
    }


    public static final class Builder {
        private UUID transactionId;
        private ZonedDateTime timestamp;
        private Boolean success;
        private String message;
        private AuthorizationMetaData metaData;

        private Builder() {
        }

        public static Builder anAuthorizationResponseModel() {
            return new Builder();
        }

        public Builder transactionId(UUID transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder timestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder success(Boolean success) {
            this.success = success;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder metaData(AuthorizationMetaData metaData) {
            this.metaData = metaData;
            return this;
        }

        public AuthorizationResponseModel build() {
            AuthorizationResponseModel authorizationResponseModel = new AuthorizationResponseModel();
            authorizationResponseModel.setTransactionId(transactionId);
            authorizationResponseModel.setTimestamp(timestamp);
            authorizationResponseModel.setSuccess(success);
            authorizationResponseModel.setMessage(message);
            authorizationResponseModel.setMetaData(metaData);
            return authorizationResponseModel;
        }
    }
}
