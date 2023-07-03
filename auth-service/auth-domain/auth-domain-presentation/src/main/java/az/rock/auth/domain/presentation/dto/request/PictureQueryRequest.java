package az.rock.auth.domain.presentation.dto.request;

import az.rock.lib.valueObject.PictureType;

import java.util.UUID;

public record PictureQueryRequest(UUID uuid, PictureType type,String path) {
}
