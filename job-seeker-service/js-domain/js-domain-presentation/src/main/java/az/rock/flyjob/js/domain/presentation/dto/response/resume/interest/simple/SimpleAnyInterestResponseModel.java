package az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleAnyInterestResponseModel extends AnyBaseResponseModel {
    private Boolean isHobby;
    private String name;

    public static SimpleAnyInterestResponseModel of(InterestRoot root) {
        return SimpleAnyInterestResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .isHobby(root.getHobby())
                .name(root.getName())
                .build();
    }
}
