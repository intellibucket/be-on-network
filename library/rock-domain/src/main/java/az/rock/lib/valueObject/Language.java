package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum Language {
    AZ,EN,RU,TR,UNKNOWN;

    public Boolean isSupported(String language){
        return language.equals(AZ.name()) || language.equals(EN.name()) || language.equals(RU.name()) || language.equals(TR.name());
    }

    public Boolean isAzerbaijani(){
        return this == Language.AZ;
    }

    public Boolean isEnglish(){
        return this == Language.EN;
    }

    public Boolean isRussian(){
        return this == Language.RU;
    }

    public Boolean isTurkish(){
        return this == Language.TR;
    }

    public Boolean isUnknown(){
        return this == Language.UNKNOWN;
    }
}
