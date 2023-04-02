package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.util.GDateTime;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
public final class AuthLogCommand {
    private final UUID userUUID;
    private final String username;
    private final String userPrivateKey;
    private final String ipAddress;
    private final Set<String> permissions;
    private final ZonedDateTime authDate;
    private final Boolean state = Boolean.TRUE;

    private AuthLogCommand(Builder builder) {
        userUUID = builder.userUUID;
        username = builder.username;
        userPrivateKey = builder.userPrivateKey;
        ipAddress = builder.ipAddress;
        authDate = builder.authDate;
        this.permissions = builder.permissions;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private UUID userUUID;
        private String username;
        private String userPrivateKey;
        private String ipAddress;
        private Set<String> permissions;
        private ZonedDateTime authDate = GDateTime.UTC.now();

        private Builder() {
        }


        public Builder withPermissions(Set<String> permissions) {
            this.permissions = permissions;
            return this;
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

        public Builder withAuthDate(ZonedDateTime authDate) {
            this.authDate = authDate;
            return this;
        }

        public AuthLogCommand build() {
            return new AuthLogCommand(this);
        }
    }
}
