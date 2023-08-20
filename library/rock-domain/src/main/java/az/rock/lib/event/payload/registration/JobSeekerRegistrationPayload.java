package az.rock.lib.event.payload.registration;

import az.rock.lib.event.payload.Payload;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;


public class JobSeekerRegistrationPayload implements Payload {
    private UUID userId;
    private UserType type;

    private String userName;

    private String lastName;

    public JobSeekerRegistrationPayload(UUID userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }

    public JobSeekerRegistrationPayload(){}

    private JobSeekerRegistrationPayload(Builder builder) {
        setUserId(builder.userId);
        setType(builder.type);
        userName = builder.userName;
        lastName = builder.lastName;
    }

    public UserType getType() {
        return type;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setType(UserType type) {
        this.type = type;
    }


    public static final class Builder {
        private UUID userId;
        private UserType type;
        private String userName;
        private String lastName;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder type(UserType val) {
            type = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public JobSeekerRegistrationPayload build() {
            return new JobSeekerRegistrationPayload(this);
        }
    }
}
