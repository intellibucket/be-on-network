package az.rock.lib.valueObject;

import java.util.TimeZone;

public class TimeZoneValue {
    private final String timezone;

    private TimeZoneValue(String timezone) {
        this.timezone = timezone;
    }

    public static TimeZoneValue of(String timezone){
        return new TimeZoneValue(timezone);
    }

    public static TimeZoneValue of(TimeZone timezone){
        return new TimeZoneValue(timezone.getID());
    }

    public Boolean isTimezone(String timezone){
        return this.timezone.equals(timezone);
    }

    public String getValue(){
        return timezone;
    }

    public Boolean isAzerbaijan(){
        return isTimezone("Asia/Baku");
    }

    public TimeZone toTimeZone(){
        return TimeZone.getTimeZone(timezone);
    }
}
