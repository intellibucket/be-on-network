package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.DeviceEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.DeviceRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DeviceDataAccessMapper  implements AbstractDataAccessMapper<DeviceEntity, DeviceRoot> {

    private final AuthenticationLogDataAccessMapper authenticationLogDataAccessMapper;

    private final GeoPositionDataAccessMapper geoPositionDataAccessMapper;

    private final UserDataAccessMapper userDataAccessMapper;
    public DeviceDataAccessMapper(AuthenticationLogDataAccessMapper authenticationLogDataAccessMapper,
                                  GeoPositionDataAccessMapper geoPositionDataAccessMapper,
                                  UserDataAccessMapper userDataAccessMapper) {
        this.authenticationLogDataAccessMapper = authenticationLogDataAccessMapper;
        this.geoPositionDataAccessMapper = geoPositionDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public DeviceRoot toRoot(DeviceEntity entity) {
        return DeviceRoot.Builder
                .builder()
                .build();
    }

    @Override
    public DeviceEntity toEntity(DeviceRoot root) {
        var userEntity = this.userDataAccessMapper.toEntity(root.getUser());
        var geoPositionEntity = this.geoPositionDataAccessMapper.toEntity(root.getGeoPosition());
        var authenticationLogEntity = root.getAuthenticationLogs()
                .stream()
                .map(this.authenticationLogDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return DeviceEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .user(userEntity)
                .geoPosition(geoPositionEntity)
                .authenticationLogs(authenticationLogEntity)
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
        var userEntity = this.userDataAccessMapper.toNewEntity(root.getUser());
        var geoPositionEntity = this.geoPositionDataAccessMapper.toNewEntity(root.getGeoPosition());
        var authenticationLogEntity = root.getAuthenticationLogs()
                .stream()
                .map(this.authenticationLogDataAccessMapper::toNewEntity)
                .collect(Collectors.toSet());
        return DeviceEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .user(userEntity)
                .geoPosition(geoPositionEntity)
                .authenticationLogs(authenticationLogEntity)
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
