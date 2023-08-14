package az.rock.flyjob.js.domain.core.root.template;


import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.ResumeTemplateID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.ResumeTemplateType;

import java.time.ZonedDateTime;

public class ResumeTemplateRoot extends AggregateRoot<ResumeTemplateID> {
    private ResumeID resume;
    private ResumeTemplateType resumeTemplateType;

    private ResumeTemplateRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        resume = builder.resume;
        resumeTemplateType = builder.resumeTemplateType;
    }


    public ResumeID getResume() {
        return resume;
    }

    public ResumeTemplateType getResumeTemplateType() {
        return resumeTemplateType;
    }

    public static final class Builder {
        private ResumeTemplateID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private ResumeTemplateType resumeTemplateType;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ResumeTemplateID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
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

        public Builder resumeTemplateType(ResumeTemplateType val) {
            resumeTemplateType = val;
            return this;
        }

        public ResumeTemplateRoot build() {
            return new ResumeTemplateRoot(this);
        }
    }
}
