package az.rock.flyjob.auth.dataAccess.entity.detail;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emails", schema = "auth")
@Entity(name = "EmailEntity")
public class EmailEntity extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_primary", nullable = false,columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @Column(name = "is_verified", nullable = false,columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verification_code", length = 6)
    private String verificationCode;

    @Column(name = "verification_code_expire_date")
    private String verificationCodeExpireDate;

    @Column(name = "verification_code_send_date")
    private String verificationCodeSendDate;

    @Column(name = "verification_code_send_count")
    private String verificationCodeSendCount;

}
