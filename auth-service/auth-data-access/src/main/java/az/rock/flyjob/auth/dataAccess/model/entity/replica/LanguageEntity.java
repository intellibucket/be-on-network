package az.rock.flyjob.auth.dataAccess.model.entity.replica;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "replica", name = "languages")
@Entity(name = "LanguageEntity")
public class LanguageEntity extends BaseEntity {

    private String name; // The name of the language (Example, "Türkçe", "English" )
    private String isoCode; // The Language ISO 639-1 code (Example, "tr", "en" )
    private String region; // The region where the language is spoken (Example, "Türkiye", "United States" )
    private String script; // The script used for the language (Example, "Latin", "Cyrillic" )
    private String family; // The language family (Example, "Turkic", "Indo-European" )
    private String nativeName; // The language name in the language itself (Example, "Türkçe", "English" )
    private String nativeRegion; // The region where the language is spoken in the language itself (Example, "Türkiye", "United States" )

}
