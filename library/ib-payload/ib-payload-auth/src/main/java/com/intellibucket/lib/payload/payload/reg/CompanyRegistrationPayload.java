package com.intellibucket.lib.payload.payload.reg;

import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;


public class CompanyRegistrationPayload extends Payload {
    private UUID userId;
    private UserType type;

    public CompanyRegistrationPayload(UUID userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }

    public CompanyRegistrationPayload(){}

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
}
