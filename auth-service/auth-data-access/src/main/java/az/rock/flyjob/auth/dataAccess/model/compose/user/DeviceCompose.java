package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.device.AuthenticationLogEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.device.GeoPositionEntity;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceCompose extends BaseCompose {

    private UUID userUUID;

    private Set<AuthenticationLogCompose> authenticationLogs;

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

    private GeoPositionCompose geoPosition;
}
