package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Locale;
import java.util.TimeZone;

@ValueObject
public class TimeZoneID {

    public static final TimeZoneID EMPTY = TimeZoneID.of("");
    private final String timezone;

    private TimeZoneID(String timezone) {
        this.timezone = timezone;
    }

    public static TimeZoneID of(String timezone){
        return new TimeZoneID(timezone);
    }

    public static TimeZoneID of(TimeZone timezone){
        return new TimeZoneID(timezone.getID());
    }

    public Boolean isTimezone(String timezone){
        return this.timezone.equals(timezone);
    }

    public String getValue(){
        return timezone;
    }

    @JsonIgnore
    public Boolean isAzerbaijan(){
        return isTimezone("Asia/Baku");
    }

    public TimeZone toTimeZone(){
        return TimeZone.getTimeZone(timezone);
    }

    public static class Prototype {
        public static final TimeZoneID ASIA_BAKU = TimeZoneID.of("Asia/Baku");
    }

    public Locale toLocale(String language){
        return new Locale(language, timezone);
    }
}
