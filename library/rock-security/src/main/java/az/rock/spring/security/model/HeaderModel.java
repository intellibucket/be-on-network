package az.rock.spring.security.model;

public class HeaderModel {
    private String lang;
    private String userRequestPrivateKey;
    private String ipAddress;
    private String token;
    private String unauthorizedMessage;

    public HeaderModel() {
    }


    private HeaderModel(Builder builder) {
        lang = builder.lang;
        userRequestPrivateKey = builder.userRequestPrivateKey;
        ipAddress = builder.ipAddress;
        token = builder.token;
        unauthorizedMessage = builder.unauthorizedMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUnauthorizedMessage() {
        return unauthorizedMessage;
    }

    public String getLang() {
        return lang;
    }

    public String getUserRequestPrivateKey() {
        return userRequestPrivateKey;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getToken() {
        return token;
    }


    public static final class Builder {
        private String lang;
        private String userRequestPrivateKey;
        private String ipAddress;
        private String token;
        private String unauthorizedMessage;

        private Builder() {
        }

        public Builder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public Builder withUnauthorizedMessage(String message) {
            this.unauthorizedMessage = message;
            return this;
        }

        public Builder withUserRequestPrivateKey(String userRequestPrivateKey) {
            this.userRequestPrivateKey = userRequestPrivateKey;
            return this;
        }

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public HeaderModel build() {
            if (this.unauthorizedMessage == null)
                unauthorizedMessage = "Unauthorized request";
            return new HeaderModel(this);
        }
    }


    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setUserRequestPrivateKey(String userRequestPrivateKey) {
        this.userRequestPrivateKey = userRequestPrivateKey;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUnauthorizedMessage(String unauthorizedMessage) {
        this.unauthorizedMessage = unauthorizedMessage;
    }
}
