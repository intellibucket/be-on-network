package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractContactQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContactQueryRepositoryAdapter implements AbstractContactQueryRepositoryAdapter {
    private final AbstractContactQueryJPARepository contactQueryJPARepository;
    private final AbstractContactDataAccessMapper<ContactEntity, ContactRoot> contactMapper;

    public ContactQueryRepositoryAdapter(AbstractContactQueryJPARepository contactQueryJPARepository, AbstractContactDataAccessMapper<ContactEntity, ContactRoot> contactMapper) {
        this.contactQueryJPARepository = contactQueryJPARepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public Boolean isExistContact(ContactRoot contactRoot) {
        return null;
    }

    @Override
    public Optional<ContactRoot> findOwnByID(ResumeID parentID, ContactID rootId) {
        return AbstractContactQueryRepositoryAdapter.super.findOwnByID(parentID, rootId);
    }

    @Override
    public Optional<ContactRoot> findById(ContactID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<ContactRoot> findByPID(ResumeID parentID) {
        return AbstractContactQueryRepositoryAdapter.super.findByPID(parentID);
    }

    @Override
    public List<ContactRoot> findAllByPID(ResumeID parentID) {
        return AbstractContactQueryRepositoryAdapter.super.findAllByPID(parentID);
    }
}
