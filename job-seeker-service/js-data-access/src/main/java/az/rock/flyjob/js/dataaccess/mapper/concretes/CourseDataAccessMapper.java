package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseDataAccessMapper implements AbstractCourseDataAccessMapper {


    @Override
    public Optional<CourseRoot> toRoot(CourseEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var safetyResumeEntity = optionalEntity.get();

            return Optional.of(
                    CourseRoot.Builder
                            .builder()
                            .courseTitle(safetyResumeEntity.getCourseTitle())
                            .description(safetyResumeEntity.getDescription())
                            .resume(ResumeID.of(entity.getResume().getUuid()))
                            .verificationAddress(safetyResumeEntity.getVerificationAddress())
                            .version(Version.ONE)
                            .institution(safetyResumeEntity.getInstitution())
                            .accessModifier(AccessModifier.PUBLIC)
                            .isOnline(entity.getIsOnline())
//                            .startDate() // TODO: 04.03.2024
//                            .endDate(safetyResumeEntity.getEndDate())
                            .city(safetyResumeEntity.getCity())
                            .country(safetyResumeEntity.getCountry())
                            .build()
            );
        }else return Optional.empty();


    }

    @Override
    public Optional<CourseEntity> toEntity(CourseRoot root) {
        return Optional.empty();
    }
}
