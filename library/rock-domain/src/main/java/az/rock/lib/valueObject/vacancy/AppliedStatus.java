package az.rock.lib.valueObject.vacancy;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum AppliedStatus {
    ACCEPTED,REJECTED,CANCELLED_BY_USER,IN_REVIEW,CANCELLED_BY_SYSTEM;
}
