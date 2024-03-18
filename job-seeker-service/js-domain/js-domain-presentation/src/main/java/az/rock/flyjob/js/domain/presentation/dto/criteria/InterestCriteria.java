package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.UUID;

public class InterestCriteria {
    private UUID id;
    private ResumeID resume;
    private AccessModifier accessModifier;

    private InterestCriteria(Builder builder) {
        id = builder.id;
        resume = builder.resume;
        accessModifier = builder.accessModifier;
    }


    public static final class Builder {
        private UUID id;
        private ResumeID resume;
        private AccessModifier accessModifier;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public InterestCriteria build() {
            return new InterestCriteria(this);
        }
    }
}
