package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPhoneNumberQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPhoneNumberDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.user.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.PhoneNumberQueryJPARepository;
import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneNumberQueryRepositoryAdapter implements AbstractPhoneNumberQueryRepositoryAdapter {
    private final PhoneNumberQueryJPARepository phoneNumberQueryJPARepository;
    private final AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper;

    public PhoneNumberQueryRepositoryAdapter(PhoneNumberQueryJPARepository phoneNumberQueryJPARepository,
                                             AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper) {
        this.phoneNumberQueryJPARepository = phoneNumberQueryJPARepository;
        this.phoneNumberDataAccessMapper = phoneNumberDataAccessMapper;
    }


    @Override
    public Optional<PhoneNumberRoot> findOwnByID(UserID parentID, PhoneNumberID rootId) {
        var entity = this.phoneNumberQueryJPARepository.findOwnById(parentID.getAbsoluteID(), rootId.getAbsoluteID());
        if (entity.isEmpty()) return Optional.empty();
        return this.phoneNumberDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public Optional<PhoneNumberRoot> findById(PhoneNumberID rootId) {
        var entity = this.phoneNumberQueryJPARepository.findById(rootId.getAbsoluteID());
        if (entity.isEmpty()) return Optional.empty();
        return this.phoneNumberDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public List<PhoneNumberRoot> findAllByPID(UserID parentID) {
        var phoneNumberEntityList = phoneNumberQueryJPARepository.findAllByUser(parentID.getAbsoluteID());
        return phoneNumberEntityList.stream()
                .map(this.phoneNumberDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Boolean isExistVerifiedPhoneNumber(PhoneNumberRoot root) {
        return this.phoneNumberQueryJPARepository.existsAnyIsVerified(root.getPhoneNumber(), root.getCountryCode());
    }
}
