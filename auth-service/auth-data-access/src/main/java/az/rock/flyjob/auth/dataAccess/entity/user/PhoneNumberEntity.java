package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.PhoneNumberType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone_numbers", schema = "auth")
@Entity(name = "PhoneNumberEntity")
public class PhoneNumberEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @Column(name = "country_code", length = 1, nullable = false)
    private String countryCode;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private PhoneNumberType type;

    @Column(name = "is_enable_sms_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableSmsNotification;

    @Column(name = "is_enable_whatsapp_notification", nullable = false,columnDefinition = "boolean default false")
    private Boolean isEnableWhatsappNotification;

    @Column(name = "is_primary", nullable = false,columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @Column(name = "is_verified", nullable = false,columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verification_code", length = 6)
    private String verificationCode;

    @Column(name = "verification_code_expire_date")
    private Timestamp verificationCodeExpireDate;

    @Column(name = "verification_code_send_date")
    private Timestamp verificationCodeSendDate;

    @Column(name = "verification_code_send_count")
    private BigInteger verificationCodeSendCount;
}
