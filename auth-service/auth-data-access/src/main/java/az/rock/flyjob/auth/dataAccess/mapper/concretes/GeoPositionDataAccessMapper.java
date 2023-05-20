package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.GeoPositionEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractGeoPositionDataAccessMapper;
import az.rock.flyjob.auth.root.GeoPositionRoot;
import org.springframework.stereotype.Component;

@Component
public class GeoPositionDataAccessMapper  implements AbstractGeoPositionDataAccessMapper<GeoPositionEntity, GeoPositionRoot> {
    @Override
    public GeoPositionRoot toRoot(GeoPositionEntity entity) {
        return null;
    }

    @Override
    public GeoPositionEntity toEntity(GeoPositionRoot root) {
        return null;
    }

    @Override
    public GeoPositionEntity toNewEntity(GeoPositionRoot root) {
        return null;
    }
}
