package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDeviceDomainMapper;
import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

@Component
public class DeviceDomainMapper implements AbstractDeviceDomainMapper {
    @Override
    public DeviceRoot registrationDevice(UserID userID) {
        return null;
    }
}
