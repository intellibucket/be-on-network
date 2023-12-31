package az.rock.lib.valueObject.vacancy;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum CompanyVerificationType {
    EMAIL,
    PHONE,
    WEBSITE,
    ADDRESS,
    OTHER
}
