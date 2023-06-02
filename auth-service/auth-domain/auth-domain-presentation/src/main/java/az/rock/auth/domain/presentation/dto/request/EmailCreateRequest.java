package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.EmailType;

import java.util.UUID;

public class EmailCreateRequest {
    private final String email;
    private final EmailType type;

    public EmailCreateRequest(String email, EmailType type) {
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }


    public EmailType getType() {
        return type;
    }
}
