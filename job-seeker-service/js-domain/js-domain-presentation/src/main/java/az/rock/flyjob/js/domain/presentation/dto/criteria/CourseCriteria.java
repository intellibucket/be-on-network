package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;

import java.util.List;
import java.util.UUID;

public class CourseCriteria {
    private CourseID id;
    private ResumeID resumeID;
    private List<AccessModifier> accessModifiers;

    public CourseCriteria() {
    }

    private CourseCriteria(Builder builder) {
        id = builder.id;
        resumeID = builder.resumeID;
        accessModifiers = builder.accessModifiers;
    }


    public static final class Builder {
        private CourseID id;
        private ResumeID resumeID;
        private List<AccessModifier> accessModifiers;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(CourseID val) {
            id = val;
            return this;
        }

        public Builder resumeID(ResumeID val) {
            resumeID = val;
            return this;
        }

        public Builder accessModifiers(List<AccessModifier> val) {
            accessModifiers = val;
            return this;
        }

        public CourseCriteria build() {
            return new CourseCriteria(this);
        }
    }
}
