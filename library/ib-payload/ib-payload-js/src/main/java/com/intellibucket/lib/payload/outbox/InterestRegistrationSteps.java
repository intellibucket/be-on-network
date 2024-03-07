package com.intellibucket.lib.payload.outbox;

public enum InterestRegistrationSteps{
    ON_STARTED_STEP, INTEREST_CREATING_STEP;
    public String getProcessName() {
        return "INTEREST_CREATED";
    }
}
