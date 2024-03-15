package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AbstractEducationQueryBatisRepository {
    List<EducationEntity> findAllMyEducations(UUID resumeId, SimplePageableRequest simplePageableRequest);

    List<EducationEntity> findAllMySimpleEducations(UUID resumeId, SimplePageableRequest simplePageableRequest);

    List<EducationEntity> findAllAnyEducations(UUID resumeId, SimplePageableRequest simplePageableRequest);

}
