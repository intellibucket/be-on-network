package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.LinkID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.LinkType;

import java.time.ZonedDateTime;

public class LinkRoot extends AggregateRoot<LinkID> {
    private InformationID information;

    private AccessModifier accessModifier;
    private Integer orderNumber;
    private LinkType type;
    private String explanation;

    private String link;

    private LinkRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.information = builder.information;
        this.type = builder.type;
        this.explanation = builder.explanation;
        this.link = builder.link;
        this.orderNumber = builder.orderNumber;
    }


    public InformationID getInformation() {
        return information;
    }

    public LinkType getType() {
        return type;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getLink() {
        return link;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private LinkID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private InformationID information;

        private AccessModifier accessModifier;
        private Integer orderNumber;
        private LinkType type;
        private String explanation;
        private String link;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(LinkID val) {
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

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder rowOrder(Integer val){
            orderNumber = val;
            return this;
        }

        public Builder information(InformationID val) {
            information = val;
            return this;
        }

        public Builder type(LinkType val) {
            type = val;
            return this;
        }

        public Builder explanation(String val) {
            explanation = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public LinkRoot build() {
            return new LinkRoot(this);
        }
    }
}
