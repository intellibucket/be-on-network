package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.CustomPaneID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.PaneType;

import java.time.ZonedDateTime;
import java.util.UUID;


public class CustomPaneRoot extends AggregateRoot<CustomPaneID> {
    private ResumeID resume;

    private Integer orderNumber;
    private String name;

    private PaneType type;

    private String title;

    private String link;

    private String subtitle;

    private UUID cityId;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private String description;

    private CustomPaneRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.name = builder.name;
        this.type = builder.type;
        this.title = builder.title;
        this.link = builder.link;
        this.subtitle = builder.subtitle;
        this.cityId = builder.cityId;
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

    public String getName() {
        return name;
    }

    public PaneType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public UUID getCityId() {
        return cityId;
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

    public static final class Builder {
        private CustomPaneID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;

        private Integer orderNumber;
        private String name;
        private PaneType type;
        private String title;
        private String link;
        private String subtitle;
        private UUID cityId;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(CustomPaneID val) {
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

        public Builder type(PaneType val) {
            type = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder subtitle(String val) {
            subtitle = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
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

        public CustomPaneRoot build() {
            return new CustomPaneRoot(this);
        }
    }
}
