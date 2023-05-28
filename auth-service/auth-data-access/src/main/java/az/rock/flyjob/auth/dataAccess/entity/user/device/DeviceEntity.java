package az.rock.flyjob.auth.dataAccess.entity.user.device;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "devices", schema = "auth")
@Entity(name = "DeviceEntity")
public class DeviceEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
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
    private Timestamp verificationCodeExpireDate;

    @Column(name = "verification_code_send_date")
    private Timestamp verificationCodeSendDate;

    @Column(name = "verification_code_send_count")
    private BigInteger verificationCodeSendCount;

    @Column(name = "is_verified", nullable = false,columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "is_primary", nullable = false,columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @OneToOne(mappedBy = "deviceEntity")
    private GeoPositionEntity geoPosition;

    private DeviceEntity(Builder builder) {
        setUser(builder.user);
        setAuthenticationLogs(builder.authenticationLogs);
        setDeviceName(builder.deviceName);
        setDeviceModel(builder.deviceModel);
        setDeviceManufacturer(builder.deviceManufacturer);
        setOperatingSystem(builder.operatingSystem);
        setDeviceOsVersion(builder.deviceOsVersion);
        setBrowserName(builder.browserName);
        setIpAddress(builder.ipAddress);
        setSalt(builder.salt);
        setHash(builder.hash);
        setVerificationCode(builder.verificationCode);
        setVerificationCodeExpireDate(builder.verificationCodeExpireDate);
        setVerificationCodeSendDate(builder.verificationCodeSendDate);
        setVerificationCodeSendCount(builder.verificationCodeSendCount);
        setIsVerified(builder.isVerified);
        setIsPrimary(builder.isPrimary);
        setGeoPosition(builder.geoPosition);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private Set<AuthenticationLogEntity> authenticationLogs;
        private String deviceName;
        private String deviceModel;
        private String deviceManufacturer;
        private String operatingSystem;
        private String deviceOsVersion;
        private String browserName;
        private String ipAddress;
        private String salt;
        private String hash;
        private String verificationCode;
        private Timestamp verificationCodeExpireDate;
        private Timestamp verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;
        private Boolean isVerified;
        private Boolean isPrimary;
        private GeoPositionEntity geoPosition;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder authenticationLogs(Set<AuthenticationLogEntity> val) {
            authenticationLogs = val;
            return this;
        }

        public Builder deviceName(String val) {
            deviceName = val;
            return this;
        }

        public Builder deviceModel(String val) {
            deviceModel = val;
            return this;
        }

        public Builder deviceManufacturer(String val) {
            deviceManufacturer = val;
            return this;
        }

        public Builder operatingSystem(String val) {
            operatingSystem = val;
            return this;
        }

        public Builder deviceOsVersion(String val) {
            deviceOsVersion = val;
            return this;
        }

        public Builder browserName(String val) {
            browserName = val;
            return this;
        }

        public Builder ipAddress(String val) {
            ipAddress = val;
            return this;
        }

        public Builder salt(String val) {
            salt = val;
            return this;
        }

        public Builder hash(String val) {
            hash = val;
            return this;
        }

        public Builder verificationCode(String val) {
            verificationCode = val;
            return this;
        }

        public Builder verificationCodeExpireDate(Timestamp val) {
            verificationCodeExpireDate = val;
            return this;
        }

        public Builder verificationCodeSendDate(Timestamp val) {
            verificationCodeSendDate = val;
            return this;
        }

        public Builder verificationCodeSendCount(BigInteger val) {
            verificationCodeSendCount = val;
            return this;
        }

        public Builder isVerified(Boolean val) {
            isVerified = val;
            return this;
        }

        public Builder isPrimary(Boolean val) {
            isPrimary = val;
            return this;
        }

        public Builder geoPosition(GeoPositionEntity val) {
            geoPosition = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public DeviceEntity build() {
            return new DeviceEntity(this);
        }
    }
}
