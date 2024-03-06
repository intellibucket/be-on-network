package az.rock.lib.valueObject.vacancy;

public enum SeniorityStatus {
    UNDEFINED("Undefined"),
    ENTRY_LEVEL("Entry Level"),
    JUNIOR_ASSOCIATE("Junior/Associate"),
    MID_LEVEL("Mid-Level"),
    SENIOR("Senior"),
    LEAD("Lead"),
    MANAGER("Manager"),
    DIRECTOR("Director"),
    VICE_PRESIDENT("Vice President"),
    SENIOR_VICE_PRESIDENT("Senior Vice President"),
    EXECUTIVE("Executive/Chief Officer");

    private final String description;
    SeniorityStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
