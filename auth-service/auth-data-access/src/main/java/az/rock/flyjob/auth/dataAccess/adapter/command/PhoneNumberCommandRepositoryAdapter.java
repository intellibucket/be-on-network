package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPhoneNumberCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPhoneNumberDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.user.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractPhoneNumberCommandJPARepository;
import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneNumberCommandRepositoryAdapter implements AbstractPhoneNumberCommandRepositoryAdapter {
    private final AbstractPhoneNumberCommandJPARepository phoneNumberCommandJPARepository;
    private final AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper;

    public PhoneNumberCommandRepositoryAdapter(AbstractPhoneNumberCommandJPARepository phoneNumberCommandJPARepository,
                                               AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper) {
        this.phoneNumberCommandJPARepository = phoneNumberCommandJPARepository;
        this.phoneNumberDataAccessMapper = phoneNumberDataAccessMapper;
    }


    @Override
    public Optional<PhoneNumberRoot> create(PhoneNumberRoot root) {
        var entity = this.phoneNumberDataAccessMapper.toEntity(root);
        if (entity.isEmpty()) return Optional.empty();
        var savedEntity = this.phoneNumberCommandJPARepository.persist(entity.get());
        return this.phoneNumberDataAccessMapper.toRoot(savedEntity);
    }

    @Override
    public void update(PhoneNumberRoot root) {
        var entity = this.phoneNumberDataAccessMapper.toEntity(root);
        entity.ifPresent(this.phoneNumberCommandJPARepository::merge);
    }

    @Override
    public void updateAll(List<PhoneNumberRoot> roots) {
        var entityList = roots
                .stream()
                .map(this.phoneNumberDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.phoneNumberCommandJPARepository.updateAll(entityList);
    }

    @Override
    public void inActive(PhoneNumberRoot root) {
        var entity = this.phoneNumberDataAccessMapper.toEntity(root);
        entity.ifPresent(this.phoneNumberCommandJPARepository::delete);
    }
}
