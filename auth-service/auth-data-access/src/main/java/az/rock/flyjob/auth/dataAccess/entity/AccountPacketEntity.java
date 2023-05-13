package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccountPacketType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_packet", schema = "auth")
@Entity(name = "AccountPacketEntity")
public class AccountPacketEntity extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(name = "type", nullable = false, length = 100,columnDefinition = "varchar(20) default 'FREE'")
    private AccountPacketType type;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "expired_date", nullable = false)
    private Timestamp expiredDate;

    @Column(name = "is_expired", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExpired;

}
