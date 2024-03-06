package az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple;

import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleMyCourseResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private String courseTitle;
    private Boolean isVerified;
}
