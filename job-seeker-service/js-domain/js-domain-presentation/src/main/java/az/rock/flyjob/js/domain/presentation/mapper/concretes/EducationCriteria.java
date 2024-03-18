package az.rock.flyjob.js.domain.presentation.mapper.concretes;
public class EducationCriteria {

    public EducationCriteria andRowStatusEqualTo(String value) {
        addCriterion("row_status =", value, "rowStatus");
        return (EducationCriteria) this;
    }
    public EducationCriteria andResumeUuidEqualTo(Object value) {
        addCriterion("resume_uuid =", value, "resumeUuid");
        return (EducationCriteria) this;
    }

}
