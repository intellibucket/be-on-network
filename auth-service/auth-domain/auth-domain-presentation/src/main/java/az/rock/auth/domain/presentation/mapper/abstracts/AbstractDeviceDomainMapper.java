package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.domain.id.UserID;

public interface AbstractDeviceDomainMapper {
    DeviceRoot registrationDevice(UserID userID);
}
