package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.spring.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "user", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity {
}
