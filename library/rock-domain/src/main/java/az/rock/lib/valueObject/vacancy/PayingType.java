package az.rock.lib.valueObject.vacancy;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum PayingType {
    MONTHLY, HALF_MONTHLY, WEEKLY, DAILY, HOURLY;
}
