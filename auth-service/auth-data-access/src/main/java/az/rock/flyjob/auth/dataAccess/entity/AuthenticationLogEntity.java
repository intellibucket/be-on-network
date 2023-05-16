package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authentication_logs", schema = "auth")
@Entity(name = "AuthenticationLogEntity")
public class AuthenticationLogEntity extends BaseEntity {
    @ManyToOne
    private DeviceEntity device;

    @Column(name = "device_token", nullable = false, updatable = false)
    private UUID deviceToken;
}
