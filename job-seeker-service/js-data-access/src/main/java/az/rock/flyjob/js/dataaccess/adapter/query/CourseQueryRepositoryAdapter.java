package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.CourseComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.CourseBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractCourseQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class CourseQueryRepositoryAdapter implements AbstractCourseQueryRepositoryAdapter {

    private final AbstractCourseQueryJPARepository courseQueryJPARepository;

    private final CourseBatisRepository courseQueryBatisRepository;
    private final AbstractCourseDataAccessMapper courseDataAccessMapper;

    public CourseQueryRepositoryAdapter(AbstractCourseQueryJPARepository courseQueryJPARepository, CourseBatisRepository courseQueryBatisRepository, AbstractCourseDataAccessMapper courseDataAccessMapper) {
        this.courseQueryJPARepository = courseQueryJPARepository;
        this.courseQueryBatisRepository = courseQueryBatisRepository;
        this.courseDataAccessMapper = courseDataAccessMapper;
    }

    @Override
    public Boolean existsByEquality(CourseRoot root) {
        return courseQueryJPARepository.existsByEquality(root.getCourseTitle(), root.getResume().getRootID(),root.getRootID().getRootID());
    }

    @Override
    public Optional<CourseRoot> findById(CourseID courseID,ResumeID resumeID,List<AccessModifier> accessModifiers){
        var courseEntity = courseQueryJPARepository.findById(courseID.getRootID(),resumeID.getRootID(),accessModifiers);
        if(courseEntity.isEmpty())return Optional.empty();
        return courseDataAccessMapper.toRoot(courseEntity.get());
    }

    @Override
    public List<CourseRoot> findAllByResume(ResumeID resumeID,List<AccessModifier> accessModifiers) {
        var courses = courseQueryJPARepository.findAllByResume(resumeID.getRootID(),accessModifiers);
        return courses.stream()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Boolean isInLimit(Long limit,ResumeID resumeId) {
        return courseQueryJPARepository.isInLimit(limit,resumeId.getRootID());
    }

    @Override
    public List<CourseRoot> findAllMyCourses(SimplePageableRequest pageableRequest, ResumeID resumeID) {
        var courseComposeExample = new CourseComposeExample();
        courseComposeExample.createCriteria()
                .andResumeUuidEqualTo(resumeID.getRootID())
                .andRowStatusEqualTo(RowStatus.ACTIVE.name());
        courseComposeExample.setOrderByClause("order_number");

        return courseQueryBatisRepository.selectByExample(courseComposeExample)
                .stream()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<CourseRoot> findAllAnyCourses(ResumeID targetResumeId, SimplePageableRequest pageableRequest,List<AccessModifier> accessModifiers) {
        var courseComposeExample = new CourseComposeExample();
        courseComposeExample.createCriteria()
                .andResumeUuidEqualTo(targetResumeId.getRootID())
                .andRowStatusEqualTo(RowStatus.ACTIVE.name())
                .andAccessModifierIn(accessModifiers.stream().map(AccessModifier::name).toList());
        courseComposeExample.setOrderByClause("order_number");
        return courseQueryBatisRepository.selectByExample(courseComposeExample)
                .stream()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<CourseRoot> findMyCourseById(CourseID id,ResumeID resumeID) {
        var courseComposeExample = new CourseComposeExample();
        courseComposeExample.createCriteria()
                .andUuidEqualTo(id.getRootID())
                .andResumeUuidEqualTo(resumeID.getRootID())
                .andRowStatusEqualTo(RowStatus.ACTIVE.name());
        return courseQueryBatisRepository.selectByExample(courseComposeExample)
                .stream()
                .findFirst()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }
}
