package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.domain.id.js.CourseID;

import java.util.Optional;
import java.util.UUID;


public interface AbstractCourseCommandRepositoryAdapter {
    Optional<CourseRoot> merge(CourseRoot root);
    Optional<CourseRoot> delete(UUID id);

    Optional<CourseRoot> updateCertificatePath(UUID id,String newFilePath);

}
