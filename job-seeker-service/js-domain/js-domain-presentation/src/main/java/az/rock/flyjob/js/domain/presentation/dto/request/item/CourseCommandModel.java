package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCommandModel  extends AbstractCommandModel {
    private String courseTitle;
    private String institution;
    private Boolean isOnline;
    private String city;
    private String country;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;
    private String verificationAddress;
}
