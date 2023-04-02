package az.rock.spring.security.core;

public class JwtConfig {
    private String secret;
    private Long expiration;

    private JwtConfig(Builder builder) {
        secret = builder.secret;
        expiration = builder.expiration;
    }


    public String getSecret() {
        return secret;
    }

    public Long getExpiration() {
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

        @Override
        public String toString() {
            return "SECRET: " + "[...]" + " EXPIRATION: " + expiration;
        }

        public JwtConfig build() {
            return new JwtConfig(this);
        }
    }

    @Override
    public String toString() {
        return "SECRET: " + "[...]" + " EXPIRATION: " + expiration;
    }
}
