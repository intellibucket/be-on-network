package az.rock.spring.security.core;

public class JwtConfig {
    private String secret;
    private long expiration;

    private JwtConfig(Builder builder) {
        secret = builder.secret;
        expiration = builder.expiration;
    }


    public String getSecret() {
        return secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public static final class Builder {
        private String secret;
        private long expiration;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public Builder expiration(long expiration) {
            this.expiration = expiration;
            return this;
        }

        public JwtConfig build() {
            return new JwtConfig(this);
        }
    }
}
