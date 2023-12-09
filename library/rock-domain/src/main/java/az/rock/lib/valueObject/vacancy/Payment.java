package az.rock.lib.valueObject.vacancy;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum Payment {
    MONTHLY, HALF_MONTHLY, WEEKLY, DAILY, HOURLY;
}
