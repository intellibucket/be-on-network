package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;


public class ContactRoot extends AggregateRoot<ContactID> {
    private ResumeID resume;

    private ContactFormatType formatType;

    private ContactLiveType liveType;

    private String data;

    private ContactRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        setResume(builder.resume);
        setFormatType(builder.formatType);
        setLiveType(builder.liveType);
        setData(builder.data);
    }


    public ResumeID getResume() {
        return resume;
    }

    public void setResume(ResumeID resume) {
        this.resume = resume;
    }

    public ContactFormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(ContactFormatType formatType) {
        this.formatType = formatType;
    }

    public ContactLiveType getLiveType() {
        return liveType;
    }

    public void setLiveType(ContactLiveType liveType) {
        this.liveType = liveType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static final class Builder {

        private ContactID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;
        private ContactFormatType formatType;
        private ContactLiveType liveType;
        private String data;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ContactID val) {
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

        public Builder formatType(ContactFormatType val) {
            formatType = val;
            return this;
        }

        public Builder liveType(ContactLiveType val) {
            liveType = val;
            return this;
        }

        public Builder data(String val) {
            data = val;
            return this;
        }


        public ContactRoot build() {
            return new ContactRoot(this);
        }
    }
}
