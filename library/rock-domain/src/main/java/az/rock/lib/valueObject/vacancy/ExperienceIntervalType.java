package az.rock.lib.valueObject.vacancy;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum ExperienceIntervalType {
    INTERN("Intern"),
    NO_EXPERIENCE("No Experience"),
    ONLY_ONE_YEAR("< 1 Year"),
    TWO_YEARS("+2 Years"),
    THREE_YEARS("+3 Years"),
    FOUR_YEARS("+4 Years"),
    FIVE_YEARS("+5 Years"),
    TEN_YEARS("+10 Years"),
    TWENTY_YEARS("+20 Years");

    private final String description;
    ExperienceIntervalType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
