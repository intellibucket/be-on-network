package az.rock.auth.domain.presentation.dto.request;


public record PasswordChangeRequest(String oldPassword, String newPassword, Boolean closeAllSessions) {

}
