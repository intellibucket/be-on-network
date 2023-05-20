package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPhoneNumberDataAccessMapper;
import az.rock.flyjob.auth.root.PhoneNumberRoot;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDataAccessMapper implements AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> {
    @Override
    public PhoneNumberRoot toRoot(PhoneNumberEntity entity) {
        return null;
    }

    @Override
    public PhoneNumberEntity toEntity(PhoneNumberRoot root) {
        return null;
    }

    @Override
    public PhoneNumberEntity toNewEntity(PhoneNumberRoot root) {
        return null;
    }
}
