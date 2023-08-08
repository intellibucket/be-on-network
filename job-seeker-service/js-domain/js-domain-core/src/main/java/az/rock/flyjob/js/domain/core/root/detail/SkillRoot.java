package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.SkillID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.SkillLevel;

import java.time.ZonedDateTime;

public class SkillRoot extends AggregateRoot<SkillID> {
    private ResumeID resume;

    private String skillName;

    private SkillLevel skillLevel;

    private String information;

    private SkillRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        resume = builder.resume;
        skillName = builder.skillName;
        skillLevel = builder.skillLevel;
        information = builder.information;
    }


    public ResumeID getResume() {
        return resume;
    }

    public String getSkillName() {
        return skillName;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public String getInformation() {
        return information;
    }

    public static final class Builder {
        private SkillID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private String skillName;
        private SkillLevel skillLevel;
        private String information;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(SkillID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }
        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder skillName(String val) {
            skillName = val;
            return this;
        }

        public Builder skillLevel(SkillLevel val) {
            skillLevel = val;
            return this;
        }

        public Builder information(String val) {
            information = val;
            return this;
        }


        public SkillRoot build() {
            return new SkillRoot(this);
        }
    }
}