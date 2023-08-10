package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ReferenceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class ReferenceRoot extends AggregateRoot<ReferenceID> {
    private ResumeID resume;

    private Integer orderNumber;
    private String name;

    private String position;

    private String jobTitle;

    private String organization;

    private String email;

    private String phone;


    private ReferenceRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.name = builder.name;
        this.position = builder.position;
        this.jobTitle = builder.jobTitle;
        this.organization = builder.organization;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public static final class Builder {

        private ReferenceID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private Integer orderNumber;
        private String name;
        private String position;
        private String jobTitle;
        private String organization;
        private String email;
        private String phone;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ReferenceID val) {
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

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder position(String val) {
            position = val;
            return this;
        }

        public Builder jobTitle(String val) {
            jobTitle = val;
            return this;
        }

        public Builder organization(String val) {
            organization = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }


        public ReferenceRoot build() {
            return new ReferenceRoot(this);
        }
    }
}
