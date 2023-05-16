package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "devices", schema = "auth")
@Entity(name = "DeviceEntity")
public class DeviceEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "device")
    private Set<AuthenticationLogEntity> authenticationLogs;

    @Column(name = "device_name", length = 100)
    private String deviceName;

    @Column(name = "device_model", length = 100)
    private String deviceModel;

    @Column(name = "device_manufacturer", length = 100)
    private String deviceManufacturer;

    @Column(name = "operation_system", length = 100)
    private String operatingSystem;

    @Column(name = "device_os_version", length = 100)
    private String deviceOsVersion;

    @Column(name = "browser_name", length = 100)
    private String browserName;

    @Column(name = "ip_address", length = 100)
    private String ipAddress;

    @Column(name = "salt", length = 200)
    private String salt;

    @Column(name = "hash", length = 1000)
    private String hash;

    @Column(name = "verification_code", length = 6)
    private String verificationCode;

    @Column(name = "verification_code_expire_date")
    private String verificationCodeExpireDate;

    @Column(name = "verification_code_send_date")
    private String verificationCodeSendDate;

    @Column(name = "verification_code_send_count")
    private String verificationCodeSendCount;

    @Column(name = "is_verified", nullable = false,columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "is_primary", nullable = false,columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @OneToOne(mappedBy = "deviceEntity")
    private GeoPositionEntity geoPosition;


}
