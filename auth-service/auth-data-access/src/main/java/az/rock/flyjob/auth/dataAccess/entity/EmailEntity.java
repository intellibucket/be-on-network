package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.EmailType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emails", schema = "auth")
@Entity(name = "EmailEntity")
public class EmailEntity extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(name = "type", nullable = false)
    private EmailType type;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_enable_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableNotification;

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

    @Column(name = "is_subscribed_promotions", nullable = false,columnDefinition = "boolean default false")
    private Boolean isSubscribedPromotions;

    @Column(name = "subscribed_date")
    private Timestamp subscribedDate;

}
