package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDeviceDataAccessMapper;
import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.domain.id.DeviceID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DeviceDataAccessMapper  implements AbstractDeviceDataAccessMapper<DeviceEntity, DeviceRoot> {

    @Override
    public Optional<DeviceRoot> toRoot(DeviceEntity entity) {
        var optionalDeviceEntity = Optional.ofNullable(entity);
        if (optionalDeviceEntity.isEmpty()) return Optional.empty();
        return Optional.of(DeviceRoot.Builder
                        .builder()
                        .deviceID(DeviceID.of(entity.getUuid()))
                        .version(entity.getVersion())
                        .processStatus(entity.getProcessStatus())
                        .rowStatus(entity.getRowStatus())
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .deviceName(entity.getDeviceName())
                        .deviceModel(entity.getDeviceModel())
                        .deviceManufacturer(entity.getDeviceManufacturer())
                        .operatingSystem(entity.getOperatingSystem())
                        .deviceOsVersion(entity.getDeviceOsVersion())
                        .browserName(entity.getBrowserName())
                        .ipAddress(entity.getIpAddress())
                        .salt(entity.getSalt())
                        .hash(entity.getHash())
                        .verificationCode(entity.getVerificationCode())
                        .verificationCodeExpireDate(GDateTime.toZonedDateTime(entity.getVerificationCodeExpireDate()))
                .build());
    }

    @Override
    public Optional<DeviceEntity> toEntity(DeviceRoot root) {
        var optionalDeviceRoot = Optional.ofNullable(root);
        if (optionalDeviceRoot.isEmpty()) return Optional.empty();
        return Optional.of(DeviceEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
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
                .build());
    }

    @Override
    public Optional<DeviceEntity> toNewEntity(DeviceRoot root) {
        var optionalDeviceRoot = Optional.ofNullable(root);
        if (optionalDeviceRoot.isEmpty()) return Optional.empty();
        return Optional.of(DeviceEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
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
                .build());
    }
}
