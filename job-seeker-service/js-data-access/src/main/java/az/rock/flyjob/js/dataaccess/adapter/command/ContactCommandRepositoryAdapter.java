package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractContactCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractResumeCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractContactCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ContactCommandRepositoryAdapter implements AbstractContactCommandRepositoryAdapter {
    private final AbstractContactDataAccessMapper abstractContactDataAccessMapper;
    private final AbstractContactCommandJPARepository repository;

    public ContactCommandRepositoryAdapter(AbstractContactDataAccessMapper abstractContactDataAccessMapper, AbstractContactCommandJPARepository repository) {
        this.abstractContactDataAccessMapper = abstractContactDataAccessMapper;
        this.repository = repository;
    }

    @Override
    public Optional<ContactRoot> create(ContactRoot root) {
        var optional = this.abstractContactDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return Optional.empty();
        else return this.abstractContactDataAccessMapper.toRoot(
                repository.saveAndFlush(optional.get())
        );    }
    @Override
    public Optional<ContactRoot> update(ContactRoot root) {
        var optionalEntity = this.abstractContactDataAccessMapper.toEntity(root);
        if (optionalEntity.isEmpty()) {
            return Optional.empty();
        }
//
//        ContactEntity entityToUpdate = optionalEntity.get();
//
//        entityToUpdate.setFieldToUpdate(root.getFieldToUpdate());
//
//        ContactEntity updatedEntity = repository.flush(entityToUpdate);
//
//        return this.abstractContactDataAccessMapper.toRoot(updatedEntity);
        return null;
    }

    @Override
    public Optional<ContactRoot> delete(UUID id) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(id);
        if (optionalContactEntity.isPresent()) {
            repository.delete(optionalContactEntity.get());
        }
        return Optional.empty();
    }
}
