package az.rock.flyjob.auth.dataAccess.model.entity.user.device;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geo_positions", schema = "auth")
@Entity(name = "GeoPositionEntity")
public class GeoPositionEntity extends BaseEntity {

    @OneToOne
    private DeviceEntity deviceEntity;

    @Column(name = "country_code", length = 2, nullable = false)
    private String countryCode;

    @Column(name = "latitude", precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "timezone", length = 100)
    private String timezone;

    @Column(name = "gmt", length = 10)
    private String gmt;

    private GeoPositionEntity(Builder builder) {
        setDeviceEntity(builder.deviceEntity);
        setCountryCode(builder.countryCode);
        setLatitude(builder.latitude);
        setLongitude(builder.longitude);
        setTimezone(builder.timezone);
        setGmt(builder.gmt);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private DeviceEntity deviceEntity;
        private String countryCode;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private String timezone;
        private String gmt;
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

        public Builder deviceEntity(DeviceEntity val) {
            deviceEntity = val;
            return this;
        }

        public Builder countryCode(String val) {
            countryCode = val;
            return this;
        }

        public Builder latitude(BigDecimal val) {
            latitude = val;
            return this;
        }

        public Builder longitude(BigDecimal val) {
            longitude = val;
            return this;
        }

        public Builder timezone(String val) {
            timezone = val;
            return this;
        }

        public Builder gmt(String val) {
            gmt = val;
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

        public GeoPositionEntity build() {
            return new GeoPositionEntity(this);
        }
    }
}
