package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDeviceDomainMapper;
import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.domain.id.auth.DeviceID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeviceDomainMapper implements AbstractDeviceDomainMapper {
    @Override
    public DeviceRoot registrationDevice(UserID userID) {
        return DeviceRoot.Builder
                .builder()
                .deviceID(DeviceID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .build();
    }
}
