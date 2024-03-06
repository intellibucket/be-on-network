package az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple;

import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleAnyCourseResponseModel extends AnyBaseResponseModel {
    private String courseTitle;
    private Boolean isVerified;
}
