package az.rock.flyjob.js.presentation.api.rest.privates.command.query;


import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.CourseQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseQueryPrivateController implements CourseQueryPrivateSpec {

//    private final AbstractCourseQueryDomainPresentationService abstractCourseQueryDomainPresentationService;
}
