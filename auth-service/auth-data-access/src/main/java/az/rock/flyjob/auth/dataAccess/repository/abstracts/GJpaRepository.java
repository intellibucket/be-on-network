package az.rock.flyjob.auth.dataAccess.repository.abstracts;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GJpaRepository<E extends BaseEntity, ID> extends JpaRepository<E, ID> {
    default void rollback(ID id) {
        var optionalEntity = this.findById(id);
        optionalEntity.ifPresent((entity) -> {
            entity.setActive(RowStatus.ROLLBACK);
            this.save(entity);
        });
    }
}
