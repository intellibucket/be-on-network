package az.rock.flyjob.js.domain.presentation.dto.response.resume.course;

import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@SuperBuilder
public class AnyCourseResponseModel extends AnyBaseResponseModel {
    private String courseTitle;
    private String institution;
    private Boolean isOnline;
    private String city;
    private String country;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
    private Boolean isVerified;
    private String certificateUrl;
}
