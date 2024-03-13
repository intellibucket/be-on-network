package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CourseDataAccessMapper implements AbstractCourseDataAccessMapper {
    @Override
    public Optional<CourseRoot> toRoot(CourseEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var safetyResumeEntity = optionalEntity.get();
            return Optional.of(
                    CourseRoot.Builder.builder()
                            .id(CourseID.of(safetyResumeEntity.getUuid()))
                            .version(Version.of(safetyResumeEntity.getVersion()))
                            .processStatus(safetyResumeEntity.getProcessStatus())
                            .rowStatus(safetyResumeEntity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(safetyResumeEntity.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toZonedDateTime(safetyResumeEntity.getLastModifiedDate()))
                            .resume(ResumeID.of(safetyResumeEntity.getResume().getUuid()))
                            .accessModifier(safetyResumeEntity.getAccessModifier())
                            .orderNumber(safetyResumeEntity.getOrderNumber())
                            .courseTitle(safetyResumeEntity.getCourseTitle())
                            .institution(safetyResumeEntity.getInstitution())
                            .isOnline(safetyResumeEntity.getIsOnline())
                            .city(safetyResumeEntity.getCity())
                            .country(safetyResumeEntity.getCountry())
                            .startDate(safetyResumeEntity.getStartDate())
                            .endDate(safetyResumeEntity.getEndDate())
                            .description(safetyResumeEntity.getDescription())
                            .certificateFilePath(safetyResumeEntity.getCertificateFilePath())
                            .verificationAddress(safetyResumeEntity.getVerificationAddress())
                            .build()
            );
        }else return Optional.empty();


    }
    @Override
    public Optional<CourseEntity> toEntity(CourseRoot root) {
        var optionalCourseRoot = Optional.ofNullable(root);
        if(optionalCourseRoot.isPresent()) {
            var safetyCourseRoot = optionalCourseRoot.get();
            var resume  = ResumeEntity.referenceOf(safetyCourseRoot.getResume().getRootID());
            var courseEntity = CourseEntity.Builder.builder()
                    .setUuid(safetyCourseRoot.getRootID().getAbsoluteID())
                    .setVersion(safetyCourseRoot.getVersionValue())
                    .setProcessStatus(safetyCourseRoot.getProcessStatus())
                    .setRowStatus(safetyCourseRoot.getRowStatus())
                    .setCreatedDate(GDateTime.toTimestamp(safetyCourseRoot.getCreatedDate()))
                    .setLastModifiedDate(GDateTime.toTimestamp(safetyCourseRoot.getModificationDate()))
                    .setResume(resume)
                    .setAccessModifier(safetyCourseRoot.getAccessModifier())
                    .setOrderNumber(safetyCourseRoot.getOrderNumber())
                    .setCourseTitle(safetyCourseRoot.getCourseTitle())
                    .setInstitution(safetyCourseRoot.getInstitution())
                    .setIsOnline(safetyCourseRoot.getOnline())
                    .setCity(safetyCourseRoot.getCity())
                    .setCountry(safetyCourseRoot.getCountry())
                    .setStartDate(safetyCourseRoot.getStartDate())
                    .setEndDate(safetyCourseRoot.getEndDate())
                    .setDescription(safetyCourseRoot.getDescription())
                    .setCertificateFilePath(safetyCourseRoot.getCertificateFilePath())
                    .setVerificationAddress(safetyCourseRoot.getVerificationAddress())
                    .build();
            return Optional.of(courseEntity);
        }
        else return Optional.empty();




    }
}
