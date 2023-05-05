package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class Address {
    private String city;
    private String country;
    private String street;
    private String postalCode;

    public Address(String city, String country, String street, String postalCode) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.postalCode = postalCode;
    }

    private Address(Builder builder) {
        city = builder.city;
        country = builder.country;
        street = builder.street;
        postalCode = builder.postalCode;
    }


    public static final class Builder {
        private String city;
        private String country;
        private String street;
        private String postalCode;

        public Builder() {
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

        public Address build() {
            return new Address(this);
        }
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
}
