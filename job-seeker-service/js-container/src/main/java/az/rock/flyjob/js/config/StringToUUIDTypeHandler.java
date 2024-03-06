package az.rock.flyjob.js.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToUUIDTypeHandler implements Converter<String, UUID> {
    @Override
    public UUID convert(final String value) {
        try {
            return UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Geçersiz UUID formatı");
        }
    }
}
