package az.rock.flyjob.js.dataaccess.model.batis.client;

import az.rock.flyjob.js.dataaccess.model.batis.model.Interests;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterestsMapper {
    long countByExample(InterestsExample example);

    int deleteByExample(InterestsExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(Interests record);

    int insertSelective(Interests record);

    List<Interests> selectByExample(InterestsExample example);

    Interests selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") Interests record, @Param("example") InterestsExample example);

    int updateByExample(@Param("record") Interests record, @Param("example") InterestsExample example);

    int updateByPrimaryKeySelective(Interests record);

    int updateByPrimaryKey(Interests record);
}