package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeviceDataAccessMapper  implements AbstractDataAccessMapper<DeviceEntity, DeviceRoot> {

    @Override
    public DeviceRoot toRoot(DeviceEntity entity) {
        return DeviceRoot.Builder
                .builder()
                .build();
    }

    @Override
    public DeviceEntity toEntity(DeviceRoot root) {
        return DeviceEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .deviceName(root.getDeviceName())
                .deviceModel(root.getDeviceModel())
                .deviceManufacturer(root.getDeviceManufacturer())
                .operatingSystem(root.getOperatingSystem())
                .deviceOsVersion(root.getDeviceOsVersion())
                .browserName(root.getBrowserName())
                .ipAddress(root.getIpAddress())
                .salt(root.getSalt())
                .hash(root.getHash())
                .verificationCode(root.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toTimestamp(root.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toTimestamp(root.getVerificationCodeSendDate()))
                .verificationCodeSendCount(root.getVerificationCodeSendCount())
                .isVerified(root.getVerified())
                .isPrimary(root.getPrimary())
                .build();
    }

    @Override
    public DeviceEntity toNewEntity(DeviceRoot root) {
        return DeviceEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .deviceName(root.getDeviceName())
                .deviceModel(root.getDeviceModel())
                .deviceManufacturer(root.getDeviceManufacturer())
                .operatingSystem(root.getOperatingSystem())
                .deviceOsVersion(root.getDeviceOsVersion())
                .browserName(root.getBrowserName())
                .ipAddress(root.getIpAddress())
                .salt(root.getSalt())
                .hash(root.getHash())
                .verificationCode(root.getVerificationCode())
                .verificationCodeExpireDate(GDateTime.toTimestamp(root.getVerificationCodeExpireDate()))
                .verificationCodeSendDate(GDateTime.toTimestamp(root.getVerificationCodeSendDate()))
                .verificationCodeSendCount(root.getVerificationCodeSendCount())
                .isVerified(root.getVerified())
                .isPrimary(root.getPrimary())
                .build();
    }
}
