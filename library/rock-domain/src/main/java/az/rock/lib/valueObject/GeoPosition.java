package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class GeoPosition {

    private final BigDecimal latency;

    private final BigDecimal longitude;


    private GeoPosition(BigDecimal lat, BigDecimal lng) {
        this.latency = lat;
        this.longitude = lng;
    }


    public BigDecimal getLatency() {
        return latency;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }


    public Boolean isEquals(GeoPosition geoPosition){
        return this.latency.equals(geoPosition.latency) && this.longitude.equals(geoPosition.longitude);
    }

    public Boolean isNotEquals(GeoPosition geoPosition){
        return !isEquals(geoPosition);
    }

    public Boolean isEquals(BigDecimal lat, BigDecimal lng){
        return this.latency.equals(lat) && this.longitude.equals(lng);
    }

    public Boolean isEquals(String lat, String lng){
        return isEquals(new BigDecimal(lat), new BigDecimal(lng));
    }

    public Boolean isNotEquals(BigDecimal lat, BigDecimal lng){
        return !isEquals(lat, lng);
    }

    public Boolean isNotEquals(String lat, String lng){
        return !isEquals(lat, lng);
    }

    public Boolean isAzerbaijan(){
        return isEquals("40.143105", "47.576927");
    }

    public Boolean isValid(){
        return this.latency == null || this.longitude == null || isNotEquals("0.000000", "0.000000");
    }

    public Boolean isNotValid(){
        return !isValid();
    }

    public Boolean isEmpty(){
        return this.latency == null && this.longitude == null;
    }

    public static GeoPosition of(BigDecimal lat, BigDecimal lng){
        return new GeoPosition(lat, lng);
    }


    public static GeoPosition of(String lat, String lng){
        return new GeoPosition(new BigDecimal(lat), new BigDecimal(lng));
    }

    public static GeoPosition of(Double lat, Double lng){
        return new GeoPosition(BigDecimal.valueOf(lat), BigDecimal.valueOf(lng));
    }

    public static GeoPosition of(Float lat, Float lng){
        return new GeoPosition(BigDecimal.valueOf(lat), BigDecimal.valueOf(lng));
    }

    public static GeoPosition of(Integer lat, Integer lng){
        return new GeoPosition(BigDecimal.valueOf(lat), BigDecimal.valueOf(lng));
    }

    public static GeoPosition of(Long lat, Long lng){
        return new GeoPosition(BigDecimal.valueOf(lat), BigDecimal.valueOf(lng));
    }


}
