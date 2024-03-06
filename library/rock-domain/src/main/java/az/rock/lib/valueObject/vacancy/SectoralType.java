package az.rock.lib.valueObject.vacancy;

public enum SectoralType {
    UNDEFINED("Undefined"),
    IT("IT"),
    FINANCE("Finance"),
    MARKETING("Marketing"),
    SALES("Sales"),
    HR("HR"),
    LEGAL("Legal"),
    ENGINEERING("Engineering"),
    DESIGN("Design"),
    EDUCATION("Education"),
    MEDICAL("Medical"),
    OTHER("Other");


    private final String description;
    SectoralType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
