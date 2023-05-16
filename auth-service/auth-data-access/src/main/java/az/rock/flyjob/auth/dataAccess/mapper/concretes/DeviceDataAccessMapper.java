package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.DeviceEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.DeviceRoot;
import org.springframework.stereotype.Component;

@Component
public class DeviceDataAccessMapper  implements AbstractDataAccessMapper<DeviceEntity, DeviceRoot> {
    @Override
    public DeviceRoot toRoot(DeviceEntity entity) {
        return null;
    }

    @Override
    public DeviceEntity toEntity(DeviceRoot root) {
        return null;
    }

    @Override
    public DeviceEntity toNewEntity(DeviceRoot root) {
        return null;
    }
}
