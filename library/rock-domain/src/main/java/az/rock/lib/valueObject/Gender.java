package az.rock.lib.valueObject;

public enum Gender {
    MALE,FEMALE,UNKNOWN;

    public Boolean isMale(){
        return this == Gender.MALE;
    }

    public Boolean isFemale(){
        return this == Gender.FEMALE;
    }

    public Boolean isUnknown(){
        return this == Gender.UNKNOWN;
    }

    public Boolean isEquals(Gender gender){
        return this == gender;
    }
}
