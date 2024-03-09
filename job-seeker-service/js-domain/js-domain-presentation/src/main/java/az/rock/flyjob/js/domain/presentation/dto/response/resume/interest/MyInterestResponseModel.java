package az.rock.flyjob.js.domain.presentation.dto.response.resume.interest;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
public class MyInterestResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private Boolean isHobby;
    private String name;
    private String description;

    public static MyInterestResponseModel of(InterestRoot root) {
        return MyInterestResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .orderNumber(root.getOrderNumber())
                .isHobby(root.getHobby())
                .name(root.getName())
                .description(root.getDescription())
                .build();
    }
}
