package az.rock.flyjob.js.domain.presentation.dto.response.resume.interest;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AnyInterestResponseModel extends AnyBaseResponseModel {
    private Boolean isHobby;
    private String name;
    private String description;

    public static AnyInterestResponseModel of(InterestRoot root) {
        return AnyInterestResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .isHobby(root.getHobby())
                .name(root.getName())
                .description(root.getDescription())
                .build();
    }
}
