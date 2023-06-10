package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.detail.DetailRoot;

import java.util.UUID;


public record DetailPrivateModelResponse(UUID uuid,
                                         Boolean isAccountNonExpired,
                                         Boolean isAccountNonLocked,
                                         Boolean isCredentialsNonExpired,
                                         Boolean isEnabled,
                                         Boolean isDeleted,
                                         Boolean isFrozen) {

    private DetailPrivateModelResponse(DetailRoot root){
        this(root.getRootID().getAbsoluteID(),
                root.isAccountNonExpired(),
                root.isAccountNonLocked(),
                root.isCredentialsNonExpired(),
                root.isEnabled(),
                root.isDeleted(),
                root.isFrozen());
    }

    public static DetailPrivateModelResponse of(DetailRoot root){
        return new DetailPrivateModelResponse(root);
    }
}
