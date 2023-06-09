package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractNetworkDataAccessMapper;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;

import java.util.Optional;

public class NetworkDataAccessMapper implements AbstractNetworkDataAccessMapper<NetworkRelationEntity, NetworkRelationRoot> {
    @Override
    public Optional<NetworkRelationRoot> toRoot(NetworkRelationEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<NetworkRelationEntity> toEntity(NetworkRelationRoot root) {
        return Optional.empty();
    }

    @Override
    public Optional<NetworkRelationEntity> toNewEntity(NetworkRelationRoot root) {
        return Optional.empty();
    }
}
