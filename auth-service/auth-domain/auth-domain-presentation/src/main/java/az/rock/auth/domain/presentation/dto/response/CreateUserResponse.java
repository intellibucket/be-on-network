package az.rock.auth.domain.presentation.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateUserResponse(UUID userId, String message) {
}
