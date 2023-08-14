package az.rock.flyjob.js.domain.presentation.dto.request;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

public class AddressCommandModel extends AbstractCommandModel {
    private String city;
    private String country;
    private String street;
    private String postalCode;
}
