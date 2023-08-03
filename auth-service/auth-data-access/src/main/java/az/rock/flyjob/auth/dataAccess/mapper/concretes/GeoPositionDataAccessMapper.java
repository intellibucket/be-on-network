package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.user.device.GeoPositionEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractGeoPositionDataAccessMapper;
import az.rock.flyjob.auth.root.user.device.GeoPositionRoot;
import az.rock.lib.domain.id.DeviceID;
import az.rock.lib.domain.id.GeoPositionID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GeoPositionDataAccessMapper  implements AbstractGeoPositionDataAccessMapper<GeoPositionEntity, GeoPositionRoot> {
    @Override
    public Optional<GeoPositionRoot> toRoot(GeoPositionEntity entity) {
        var optionalGeoPositionEntity = Optional.ofNullable(entity);
        if (optionalGeoPositionEntity.isEmpty()) return Optional.empty();
        return Optional.of(GeoPositionRoot.Builder
                        .builder()
                        .uuid(GeoPositionID.of(entity.getUuid()))
                        .version(entity.getVersion())
                        .processStatus(entity.getProcessStatus())
                        .rowStatus(entity.getRowStatus())
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .latitude(entity.getLatitude())
                        .longitude(entity.getLongitude())
                        .gmt(entity.getGmt())
                        .countryCode(entity.getCountryCode())
                        .device(DeviceID.of(entity.getDeviceEntity().getUuid()))
                        .timezone(TimeZoneID.of(entity.getTimezone()))
                    .build());
    }

    @Override
    public Optional<GeoPositionEntity> toEntity(GeoPositionRoot root) {
        var optionalGeoPositionRoot = Optional.ofNullable(root);
        if (optionalGeoPositionRoot.isEmpty()) return Optional.empty();
        return Optional.of(GeoPositionEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .latitude(root.getLatitude())
                .longitude(root.getLongitude())
                .gmt(root.getGmt())
                .countryCode(root.getCountryCode())
                .deviceEntity(null)
                .timezone(root.getTimezone().getValue())
                .build());
    }

    @Override
    public Optional<GeoPositionEntity> toNewEntity(GeoPositionRoot root) {
        var optionalGeoPositionRoot = Optional.ofNullable(root);
        if (optionalGeoPositionRoot.isEmpty()) return Optional.empty();
        return Optional.of(GeoPositionEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .latitude(root.getLatitude())
                .longitude(root.getLongitude())
                .gmt(root.getGmt())
                .countryCode(root.getCountryCode())
                .deviceEntity(null)
                .timezone(root.getTimezone().getValue())
                .build());
    }
}
