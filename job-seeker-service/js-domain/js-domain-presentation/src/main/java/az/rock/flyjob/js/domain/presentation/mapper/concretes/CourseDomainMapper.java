package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;
import com.intellibucket.lib.payload.payload.CourseFilePayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseDomainMapper implements AbstractCourseDomainMapper {

    @Override
    public CourseRoot toRoot(CourseCommandModel courseCommandModel, ResumeID resumeId) {
        var courseId = CourseID.of(UUID.randomUUID());
        return CourseRoot.Builder.builder()
                .courseTitle(courseCommandModel.getCourseTitle())
                .description(courseCommandModel.getDescription())
                .id(courseId)
                .country(courseCommandModel.getCountry())
                .city(courseCommandModel.getCity())
                .startDate(courseCommandModel.getStartDate())
                .endDate(courseCommandModel.getEndDate())
                .isOnline(true)
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .verificationAddress(courseCommandModel.getVerificationAddress())
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .resume(resumeId)
                .institution(courseCommandModel.getInstitution())
                .orderNumber(0)
                .build();

    }

//    @Override
//    public CourseRoot filePayload(CourseRoot course, FileMetaData courseFilePayload) {
//        return CourseRoot.Builder.builder()
//                .build();
//    }
}