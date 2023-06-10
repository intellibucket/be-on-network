package az.rock.flyjob.auth.dataAccess.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_outbox", schema = "outbox")
@Entity
public class UserOutboxEntity extends OutboxEntity {

    @Enumerated(EnumType.STRING)
    private ProcessStatus processStatus;

}
