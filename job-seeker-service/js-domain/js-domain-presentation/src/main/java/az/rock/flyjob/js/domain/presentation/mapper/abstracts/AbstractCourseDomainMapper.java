package az.rock.flyjob.js.domain.presentation.mapper.abstracts;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.payload.CourseFilePayload;

public interface AbstractCourseDomainMapper {

    CourseRoot toRoot(UserID userID);

    CourseRoot filePayload(UserID userID, CourseFilePayload courseFilePayload);
}
