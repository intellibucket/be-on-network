package az.rock.flyjob.auth.root.user.device;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.DeviceID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Set;

public final class DeviceRoot extends AggregateRoot<DeviceID> {

    private final UserID userID;

    private final Set<AuthenticationLogRoot> authenticationLogs;

    private final String deviceName;

    private final String deviceModel;

    private final String deviceManufacturer;

    private final String operatingSystem;

    private final String deviceOsVersion;

    private final String browserName;

    private final String ipAddress;

    private final String salt;

    private final String hash;

    private final String verificationCode;

    private final ZonedDateTime verificationCodeExpireDate;

    private final ZonedDateTime verificationCodeSendDate;

    private final BigInteger verificationCodeSendCount;

    private final Boolean isVerified;

    private final Boolean isPrimary;

    private final GeoPositionRoot geoPosition;



    private DeviceRoot(Builder builder) {
        super(builder.deviceID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        authenticationLogs = builder.authenticationLogs;
        deviceName = builder.deviceName;
        deviceModel = builder.deviceModel;
        deviceManufacturer = builder.deviceManufacturer;
        operatingSystem = builder.operatingSystem;
        deviceOsVersion = builder.deviceOsVersion;
        browserName = builder.browserName;
        ipAddress = builder.ipAddress;
        salt = builder.salt;
        hash = builder.hash;
        verificationCode = builder.verificationCode;
        verificationCodeExpireDate = builder.verificationCodeExpireDate;
        verificationCodeSendDate = builder.verificationCodeSendDate;
        verificationCodeSendCount = builder.verificationCodeSendCount;
        isVerified = builder.isVerified;
        isPrimary = builder.isPrimary;
        geoPosition = builder.geoPosition;
    }

    public UserID getUserID() {
        return userID;
    }

    public Set<AuthenticationLogRoot> getAuthenticationLogs() {
        return authenticationLogs;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public ZonedDateTime getVerificationCodeExpireDate() {
        return verificationCodeExpireDate;
    }

    public ZonedDateTime getVerificationCodeSendDate() {
        return verificationCodeSendDate;
    }

    public BigInteger getVerificationCodeSendCount() {
        return verificationCodeSendCount;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public GeoPositionRoot getGeoPosition() {
        return geoPosition;
    }

    public static final class Builder {

        private DeviceID deviceID;

        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private Set<AuthenticationLogRoot> authenticationLogs;
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
        private ZonedDateTime verificationCodeExpireDate;
        private ZonedDateTime verificationCodeSendDate;
        private BigInteger verificationCodeSendCount;
        private Boolean isVerified;
        private Boolean isPrimary;
        private GeoPositionRoot geoPosition;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder deviceID(DeviceID val) {
            deviceID = val;
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

        public Builder dataStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder user(UserID val) {
            userID = val;
            return this;
        }

        public Builder authenticationLogs(Set<AuthenticationLogRoot> val) {
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

        public Builder verificationCodeExpireDate(ZonedDateTime val) {
            verificationCodeExpireDate = val;
            return this;
        }

        public Builder verificationCodeSendDate(ZonedDateTime val) {
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

        public Builder geoPosition(GeoPositionRoot val) {
            geoPosition = val;
            return this;
        }

        public DeviceRoot build() {
            return new DeviceRoot(this);
        }
    }
}