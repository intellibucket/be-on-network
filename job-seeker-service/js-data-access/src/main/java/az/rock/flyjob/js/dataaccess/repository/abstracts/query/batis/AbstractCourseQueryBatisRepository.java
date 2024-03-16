package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;


import az.rock.flyjob.js.dataaccess.model.batis.model.CourseCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.CourseComposeExample;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AbstractCourseQueryBatisRepository {


    List<CourseCompose> selectByExample(CourseComposeExample courseComposeExample);

}
