package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.model.entity.user.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhoneNumberQueryJPARepository extends JpaRepository<PhoneNumberEntity, UUID> {

    @Query("SELECT row FROM PhoneNumberEntity row " +
            "WHERE (:userId = row.user.uuid) and (row.rowStatus = 'ACTIVE') and (row.processStatus = 'COMPLETED')")
    List<PhoneNumberEntity> findAllByUser(@Param(value = "userId") UUID userId);

    @Query("SELECT COUNT (row) > 0 FROM PhoneNumberEntity row " +
            "WHERE (row.rowStatus = 'ACTIVE') and" +
            " (row.processStatus = 'COMPLETED') and" +
            " (row.isVerified = true) and" +
            " (row.phoneNumber = :phoneNumber) and" +
            " (row.countryCode = :countryCode)")
    Boolean existsAnyIsVerified(String phoneNumber, String countryCode);
}
