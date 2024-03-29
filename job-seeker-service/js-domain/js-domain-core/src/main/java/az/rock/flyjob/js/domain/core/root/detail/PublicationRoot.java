package az.rock.flyjob.js.domain.core.root.detail;


import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.PublicationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class PublicationRoot extends AggregateRoot<PublicationID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String title;
    private String publisher;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;

    private PublicationRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.title = builder.title;
        this.publisher = builder.publisher;
        this.link = builder.link;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLink() {
        return link;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private PublicationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String title;
        private String publisher;
        private String link;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PublicationID val) {
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

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder publisher(String val) {
            publisher = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
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

        public Builder description(String val) {
            description = val;
            return this;
        }

        public PublicationRoot build() {
            return new PublicationRoot(this);
        }
    }
}
