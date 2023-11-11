package az.rock.flyjob.auth.model.root.user.device;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.DeviceID;
import az.rock.lib.domain.id.auth.GeoPositionID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.TimeZoneID;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class GeoPositionRoot extends AggregateRoot<GeoPositionID> {
    private final DeviceID deviceID;

    private final String countryCode;

    private final BigDecimal latitude;

    private final BigDecimal longitude;

    private final TimeZoneID timezone;

    private final String gmt;

    public GeoPositionRoot(GeoPositionID geoPositionID,
                           Long version,
                           ProcessStatus processStatus,
                           RowStatus rowStatus,
                           ZonedDateTime createdDate,
                           ZonedDateTime modificationDate,
                           DeviceID deviceID,
                           String countryCode,
                           BigDecimal latitude,
                           BigDecimal longitude,
                           TimeZoneID timezone,
                           String gmt) {
        super(geoPositionID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.deviceID = deviceID;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.gmt = gmt;
    }

    public DeviceID getDeviceID() {
        return deviceID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public TimeZoneID getTimezone() {
        return timezone;
    }

    public String getGmt() {
        return gmt;
    }

    public static final class Builder {
        private DeviceID deviceID;
        private String countryCode;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private TimeZoneID timezone;
        private String gmt;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private GeoPositionID geoPositionID;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder device(DeviceID deviceID) {
            this.deviceID = deviceID;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder latitude(BigDecimal latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(BigDecimal longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder timezone(TimeZoneID timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder gmt(String gmt) {
            this.gmt = gmt;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder createdDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modificationDate(ZonedDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder uuid(GeoPositionID geoPositionID) {
            this.geoPositionID = geoPositionID;
            return this;
        }

        public GeoPositionRoot build() {
            return new GeoPositionRoot(geoPositionID, version, processStatus, rowStatus, createdDate, modificationDate, deviceID, countryCode, latitude, longitude, timezone, gmt);
        }
    }
}