package az.rock.flyjob.js.dataaccess.model.criteria.resume.detail;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.UUID;


public class InterestCriteria {
    private UUID id;
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private Boolean isHobby;
    private String name;
    private String description;

    private InterestCriteria(Builder builder) {
        id = builder.id;
        resume = builder.resume;
        accessModifier = builder.accessModifier;
        orderNumber = builder.orderNumber;
        isHobby = builder.isHobby;
        name = builder.name;
        description = builder.description;
    }

    public UUID getId() {
        return id;
    }

    public ResumeID getResume() {
        return resume;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Boolean getHobby() {
        return isHobby;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public static final class Builder {
        private UUID id;
        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private Boolean isHobby;
        private String name;
        private String description;

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

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder isHobby(Boolean val) {
            isHobby = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public InterestCriteria build() {
            return new InterestCriteria(this);
        }
    }
}
