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
                            .city(safetyResumeEntity.getCity())
                            .accessModifier(safetyResumeEntity.getAccessModifier())
                            .courseTitle(safetyResumeEntity.getCourseTitle())
                            .createdDate(GDateTime.toZonedDateTime(safetyResumeEntity.getCreatedDate()))
                            .description(safetyResumeEntity.getDescription())
                            .country(safetyResumeEntity.getCountry())
                            .endDate(GDateTime.toZonedDateTime(safetyResumeEntity.getEndDate()))
                            .orderNumber(safetyResumeEntity.getOrderNumber())
                            .processStatus(safetyResumeEntity.getProcessStatus())
                            .certificateFilePath(safetyResumeEntity.getCertificateFilePath())
                            .rowStatus(safetyResumeEntity.getRowStatus())
                            .version(Version.of(safetyResumeEntity.getVersion()))
                            .resume(ResumeID.of(safetyResumeEntity.getResume().getUuid()))
                            .startDate(GDateTime.toZonedDateTime(safetyResumeEntity.getStartDate()))
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
                    .setCity(safetyCourseRoot.getCity())
                    .setCountry(safetyCourseRoot.getCountry())
                    .setCourseTitle(safetyCourseRoot.getCourseTitle())
                    .setAccessModifier(safetyCourseRoot.getAccessModifier())
                    .setCertificateFilePath(safetyCourseRoot.getCertificateFilePath())
                    .setDescription(safetyCourseRoot.getDescription())
                    .setEndDate(GDateTime.toTimestamp(safetyCourseRoot.getEndDate()))
                    .setInstitution(safetyCourseRoot.getInstitution())
                    .setIsOnline(safetyCourseRoot.getOnline())
                    .setOrderNumber(safetyCourseRoot.getOrderNumber())
                    .setCreatedDate(GDateTime.toTimestamp(safetyCourseRoot.getCreatedDate()))
                    .setLastModifiedDate(GDateTime.toTimestamp(safetyCourseRoot.getModificationDate()))
                    .setProcessStatus(safetyCourseRoot.getProcessStatus())
                    .setResume(resume)
                    .setStartDate(GDateTime.toTimestamp(safetyCourseRoot.getStartDate()))
                    .setRowStatus(safetyCourseRoot.getRowStatus())
                    .setVerificationAddress(safetyCourseRoot.getVerificationAddress())
                    .setVersion(safetyCourseRoot.getVersionValue())
                    .build();
            return Optional.of(courseEntity);
        }
        else return Optional.empty();




    }
}
