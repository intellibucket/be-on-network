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
