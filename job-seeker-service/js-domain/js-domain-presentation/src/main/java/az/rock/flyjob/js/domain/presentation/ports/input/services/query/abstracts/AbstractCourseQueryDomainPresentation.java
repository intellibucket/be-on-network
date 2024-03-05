package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;


import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional(readOnly = true)
public interface AbstractCourseQueryDomainPresentation {

}
