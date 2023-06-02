package az.rock.auth.domain.presentation.dto.request;


public record AuthenticationUserQuery(
        String username,
        String password
) {
    public AuthenticationUserQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
