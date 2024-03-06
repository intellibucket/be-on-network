package az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleMyCourseResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private String courseTitle;
    private Boolean isVerified;

    public static SimpleMyCourseResponseModel of(CourseRoot root) {
        return SimpleMyCourseResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .orderNumber(root.getOrderNumber())
                .courseTitle(root.getCourseTitle())
                .isVerified(root.isVerified())
                .build();
    }
}
