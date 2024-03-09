package az.rock.flyjob.js.domain.presentation.dto.response;

import az.rock.lib.valueObject.AccessModifier;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class MyBaseResponseModel extends BaseResponseModel {
    private AccessModifier accessModifier;
}
