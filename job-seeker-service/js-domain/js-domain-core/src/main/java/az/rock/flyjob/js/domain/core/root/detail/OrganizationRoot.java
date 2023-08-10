package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.OrganizationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.UUID;

public class OrganizationRoot extends AggregateRoot<OrganizationID> {
    private ResumeID resume;
    private Integer orderNumber;
    private String organizationName;
    private String position;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private UUID cityId;
    private String description;

    private OrganizationRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.organizationName = builder.organizationName;
        this.position = builder.position;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.cityId = builder.cityId;
        this.description = builder.description;
    }



    public static final class Builder {

        private OrganizationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private Integer orderNumber;
        private String organizationName;
        private String position;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private UUID cityId;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(OrganizationID val) {
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

        public Builder organizationName(String val) {
            organizationName = val;
            return this;
        }

        public Builder position(String val) {
            position = val;
            return this;
        }

        public Builder startDate(ZonedDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(ZonedDateTime val) {
            endDate = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }


        public OrganizationRoot build() {
            return new OrganizationRoot(this);
        }
    }
}
