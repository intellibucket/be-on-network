package az.rock.lib.valueObject.vacancy;

public enum VacancySkillType {
    UNDEFINED("Undefined"),
    HARD_SKILL("Hard Skill"),
    SOFT_SKILL("Soft Skill"),
    LANGUAGE("Language"),
    CERTIFICATION("Certification"),
    EDUCATION("Education"),
    EXPERIENCE("Experience"),
    OTHER("Other");

    private final String description;
    VacancySkillType(String des) {
        this.description = des;
    }
}
