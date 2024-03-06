package com.intellibucket.onnetwork.company.domain.core.command.root.replica;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.replica.LanguageID;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class LanguageRoot extends AggregateRoot<LanguageID> {
    private String name; // The name of the language (Example, "Türkçe", "English" )
    private String isoCode; // The Language ISO 639-1 code (Example, "tr", "en" )
    private String region; // The region where the language is spoken (Example, "Türkiye", "United States" )
    private String script; // The script used for the language (Example, "Latin", "Cyrillic" )
    private String family; // The language family (Example, "Turkic", "Indo-European" )
    private String nativeName; // The language name in the language itself (Example, "Türkçe", "English" )
    private String nativeRegion; // The region where the language is spoken in the language itself (Example, "Türkiye", "United States" )

}
