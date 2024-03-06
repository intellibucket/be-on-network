package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.jexception.UnsupportedOperationJException;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;
@Component
public interface AbstractContactCommandRepositoryAdapter {
    Optional<ContactRoot> create(ContactRoot root);
    Optional<ContactRoot> update(ContactRoot root);
    Optional<ContactRoot> delete(UUID id);
    default void inActive(ContactRoot root) {
        throw new UnsupportedOperationJException("Inactive");
    }
}
