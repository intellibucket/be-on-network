package az.rock.lib.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public enum GDateTime {
    UTC {
        @Override
        public ZonedDateTime now() {
            return ZonedDateTime.now(ZoneId.of("UTC"));
        }
    };

    public static ZonedDateTime of(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
    }

    public static ZonedDateTime of(LocalDateTime date) {
        return ZonedDateTime.of(date, ZoneId.of("UTC"));
    }

    public static Timestamp of(ZonedDateTime date) {
        if (date == null)
            return null;
        return Timestamp.valueOf(date.toLocalDateTime());
    }

    public static Timestamp of() {
        return Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime());
    }

    public static ZonedDateTime toZonedDateTime(Timestamp createdDate) {
        if (createdDate == null) return null;
        return createdDate.toLocalDateTime().atZone(ZoneId.of("UTC"));
    }

    public static Timestamp toTimestamp(ZonedDateTime createdDate) {
        if (createdDate == null)
            return null;
        return Timestamp.valueOf(createdDate.toLocalDateTime());
    }

    public abstract ZonedDateTime now();

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}
