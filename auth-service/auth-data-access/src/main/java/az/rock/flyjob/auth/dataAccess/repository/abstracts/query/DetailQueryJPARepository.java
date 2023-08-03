package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.model.entity.detail.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DetailQueryJPARepository extends JpaRepository<DetailEntity, UUID> {

    @Query("SELECT row FROM DetailEntity row WHERE row.user.uuid = :userID" +
            " AND row.rowStatus = 'ACTIVE'")
    Optional<DetailEntity> findByPID(@Param("userID") UUID userID);

    @Query("SELECT row FROM DetailEntity row WHERE row.uuid = :detailID" +
            " AND row = 'ACTIVE'")
    Optional<DetailEntity> findById(@Param("detailID") UUID detailID);

    @Query("SELECT row FROM DetailEntity row " +
            "WHERE row.uuid = :detailID AND row.rowStatus = 'ACTIVE' " +
            " AND row.rowStatus = 'ACTIVE'")
    Optional<DetailEntity> findByIdAndActiveStatus(@Param("detailID")UUID detailID);
}
