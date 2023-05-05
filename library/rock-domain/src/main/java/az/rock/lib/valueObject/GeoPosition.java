package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class GeoPosition {

    private final BigDecimal lat;

    private final BigDecimal lng;


    public GeoPosition(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }


    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLng() {
        return lng;
    }
}
