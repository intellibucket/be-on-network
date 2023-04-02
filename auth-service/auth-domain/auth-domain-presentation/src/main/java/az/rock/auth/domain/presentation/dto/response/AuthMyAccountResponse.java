package az.rock.auth.domain.presentation.dto.response;

import lombok.Getter;

import java.util.UUID;

@Getter
public final class AuthMyAccountResponse {
    private final UUID userUUID;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;

    private AuthMyAccountResponse(Builder builder) {
        userUUID = builder.userUUID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        username = builder.username;
        email = builder.email;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private UUID userUUID;
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        private Builder() {
        }

        public Builder withUserUUID(UUID userUUID) {
            this.userUUID = userUUID;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AuthMyAccountResponse build() {
            return new AuthMyAccountResponse(this);
        }
    }
}
