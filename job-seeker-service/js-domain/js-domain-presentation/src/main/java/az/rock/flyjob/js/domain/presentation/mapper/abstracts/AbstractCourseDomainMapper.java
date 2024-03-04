package az.rock.flyjob.js.domain.presentation.mapper.abstracts;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.payload.CourseFilePayload;
import org.springframework.stereotype.Component;


public interface AbstractCourseDomainMapper {

    CourseRoot toRoot(CourseCommandModel command);

    CourseRoot filePayload(UserID userID, CourseFilePayload courseFilePayload);
}
