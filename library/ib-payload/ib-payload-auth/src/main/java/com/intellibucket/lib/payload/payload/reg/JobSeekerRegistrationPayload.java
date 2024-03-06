package com.intellibucket.lib.payload.payload.reg;

import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;


public class JobSeekerRegistrationPayload extends Payload {
    private UUID userId;
    private UserType type;

    private String firstName;

    private String lastName;

    public JobSeekerRegistrationPayload(UUID userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }


    public JobSeekerRegistrationPayload() {
    }

    private JobSeekerRegistrationPayload(Builder builder) {
        setUserId(builder.userId);
        setType(builder.type);
        firstName = builder.userName;
        lastName = builder.lastName;
    }

    @Override
    public String toString() {
        return "JobSeekerRegistrationPayload{" +
                "userId=" + userId +
                ", type=" + type +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "}\n";
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

        public Builder firstName(String val) {
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
