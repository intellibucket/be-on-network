package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.CourseFilePayload;

import java.util.UUID;

public class CourseDomainMapper implements AbstractCourseDomainMapper {

    @Override
    public CourseRoot toRoot(CourseCommandModel courseCommandModel) {


      // TODO: 04.03.2024

        return CourseRoot.Builder.builder()
                .courseTitle(courseCommandModel.getCourseTitle())
                .description(courseCommandModel.getDescription())
                .id()
                .country(courseCommandModel.getCountry())
                .city(courseCommandModel.getCity())
                .createdDate()
                .startDate().endDate()
                .certificateFilePath().isOnline()
                .rowStatus()
                .version(Version.ONE)
                .verificationAddress()
                .accessModifier(ProcessStatus.COMPLETED)
                .lastModifiedDate()
                .processStatus(ProcessStatus.COMPLETED)
                .resume().institution()
                .orderNumber().build();

    }

    @Override
    public CourseRoot filePayload(UserID userID, CourseFilePayload courseFilePayload) {


    }
}
