package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.oot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.JobTitleInformationID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class JobTitleInformationRoot extends AggregateRoot<JobTitleInformationID> {

    private InformationID information;
    private AccessModifier accessModifier;
    private String jobTitle;

    private JobTitleInformationRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        information = builder.informationID;
        jobTitle = builder.jobTitle;
    }


    public InformationID getInformation() {
        return information;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private InformationID informationID;
        private AccessModifier accessModifier;
        private JobTitleInformationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private String jobTitle;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(JobTitleInformationID val) {
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

        public Builder information(InformationID val) {
            informationID = val;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder jobTitle(String val) {
            jobTitle = val;
            return this;
        }


        public JobTitleInformationRoot build() {
            return new JobTitleInformationRoot(this);
        }
    }
}
