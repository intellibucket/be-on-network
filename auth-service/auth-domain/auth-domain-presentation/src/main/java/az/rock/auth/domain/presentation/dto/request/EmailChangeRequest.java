package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.EmailType;

import java.util.UUID;

public class EmailChangeRequest {
    private final UUID emailUUID;
    private final String email;

    private final EmailType type;

    public EmailChangeRequest(UUID emailUUID, String email, EmailType type) {
        this.emailUUID = emailUUID;
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public UUID getEmailUUID() {
        return emailUUID;
    }

    public EmailType getType() {
        return type;
    }
}
