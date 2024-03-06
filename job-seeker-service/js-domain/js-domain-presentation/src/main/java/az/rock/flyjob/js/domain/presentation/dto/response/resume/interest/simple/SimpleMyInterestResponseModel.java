package az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleMyInterestResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private Boolean isHobby;
    private String name;

    public static SimpleMyInterestResponseModel of(InterestRoot root) {
        return SimpleMyInterestResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .orderNumber(root.getOrderNumber())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .isHobby(root.getHobby())
                .name(root.getName())
                .build();
    }
}
