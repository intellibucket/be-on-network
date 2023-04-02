package az.rock.auth.domain.presentation.dto.request;


public record AuthUserQuery(
        String username,
        String password
) {
    public AuthUserQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
