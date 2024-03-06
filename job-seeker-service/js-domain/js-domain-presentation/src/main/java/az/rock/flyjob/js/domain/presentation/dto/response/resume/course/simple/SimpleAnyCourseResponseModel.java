package az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleAnyCourseResponseModel extends AnyBaseResponseModel {
    private String courseTitle;
    private Boolean isVerified;

    public static SimpleAnyCourseResponseModel of(CourseRoot root) {
        return SimpleAnyCourseResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .courseTitle(root.getCourseTitle())
                .isVerified(root.isVerified())
                .build();
    }
}
