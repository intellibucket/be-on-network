package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.CourseFilePayload;

import java.util.UUID;

public class CourseDomainMapper implements AbstractCourseDomainMapper {

    @Override
    public CourseRoot toRoot(CourseCommandModel courseCommandModel, ResumeID resumeId) {
        var courseId = CourseID.of(UUID.randomUUID());

      // TODO: 04.03.2024

        return CourseRoot.Builder.builder()
                .courseTitle(courseCommandModel.getCourseTitle())
                .description(courseCommandModel.getDescription())
                .id(courseId)
                .country(courseCommandModel.getCountry())
                .city(courseCommandModel.getCity())
//                .createdDate()
                .startDate(courseCommandModel.getStartDate())
                .endDate(courseCommandModel.getEndDate())
//                .certificateFilePath()
                .isOnline(true)
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .verificationAddress(courseCommandModel.getVerificationAddress())
                .accessModifier(AccessModifier.PUBLIC)
//                .lastModifiedDate(COM)
                .processStatus(ProcessStatus.COMPLETED)
                .resume(resumeId)
                .institution(courseCommandModel.getInstitution())
                .orderNumber(0)
                .build();

    }

    @Override
    public CourseRoot filePayload(UserID userID, CourseFilePayload courseFilePayload) {
        return null;
    }
}
