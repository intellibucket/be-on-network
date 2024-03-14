package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;


import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AbstractCourseQueryBatisRepository {


    List<CourseEntity> findAllMyCourses(
            @Param("pageable") SimplePageableRequest pageableRequest,
            @Param("resume") UUID resumeID);

}
