package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AddressID;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class AddressRoot extends AggregateRoot<AddressID> {
    private InformationID information;
    private AccessModifier accessModifier;
    private String city;
    private String country;
    private String street;
    private String postalCode;

    private AddressRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        accessModifier = builder.accessModifier;
        information = builder.information;
        city = builder.city;
        country = builder.country;
        street = builder.street;
        postalCode = builder.postalCode;
    }



    public InformationID getInformation() {
        return information;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private AddressID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private AccessModifier accessModifier;
        private InformationID information;
        private String city;
        private String country;
        private String street;
        private String postalCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(AddressID val) {
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


        public Builder information(InformationID val) {
            information = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        public AddressRoot build() {
            return new AddressRoot(this);
        }
    }
}
