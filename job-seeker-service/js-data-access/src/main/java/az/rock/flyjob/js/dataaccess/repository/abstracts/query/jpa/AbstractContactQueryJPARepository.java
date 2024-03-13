package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.GJpaRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.criteria.ContactCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractContactQueryJPARepository extends GJpaRepository<ContactEntity, UUID> {

//    Boolean existsByFormatTypeAndDataAndLiveType();
}
