package az.rock.auth.domain.presentation.dto.request;

import lombok.Getter;


public final class PasswordChangeRequest {
    private final String oldPassword;
    private final String newPassword;

    public PasswordChangeRequest(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

}
