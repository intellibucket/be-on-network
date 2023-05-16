package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.GeoPositionID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class GeoPositionRoot extends AggregateRoot<GeoPositionID> {
    private final DeviceRoot device;

    private final String countryCode;

    private final BigDecimal latitude;

    private final BigDecimal longitude;

    private final String timezone;

    private final String gmt;

    public GeoPositionRoot(GeoPositionID geoPositionID,
                           Long version,
                           ProcessStatus processStatus,
                           DataStatus dataStatus,
                           ZonedDateTime createdDate,
                           ZonedDateTime modificationDate,
                           DeviceRoot device,
                           String countryCode,
                           BigDecimal latitude,
                           BigDecimal longitude,
                           String timezone,
                           String gmt) {
        super(geoPositionID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.device = device;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.gmt = gmt;
    }

    public DeviceRoot getDevice() {
        return device;
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

    public String getTimezone() {
        return timezone;
    }

    public String getGmt() {
        return gmt;
    }

    public static final class Builder {
        private DeviceRoot device;
        private String countryCode;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private String timezone;
        private String gmt;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private GeoPositionID geoPositionID;

        private Builder() {
        }

        public static Builder aGeoPositionRoot() {
            return new Builder();
        }

        public Builder device(DeviceRoot device) {
            this.device = device;
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

        public Builder timezone(String timezone) {
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

        public Builder dataStatus(DataStatus dataStatus) {
            this.dataStatus = dataStatus;
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
            return new GeoPositionRoot(geoPositionID, version, processStatus, dataStatus, createdDate, modificationDate, device, countryCode, latitude, longitude, timezone, gmt);
        }
    }
}