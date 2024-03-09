package az.rock.flyjob.js.domain.presentation.mapper.abstracts;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.FileMetaData;
import com.intellibucket.lib.payload.payload.CourseFilePayload;
import org.springframework.stereotype.Component;


public interface AbstractCourseDomainMapper {

    CourseRoot toRoot(CourseCommandModel courseCommandModel, ResumeID resumeID);


    CourseRoot toRoot(CourseCommandModel courseCommandModel, CourseRoot courseRoot, ResumeID resumeID);

}
