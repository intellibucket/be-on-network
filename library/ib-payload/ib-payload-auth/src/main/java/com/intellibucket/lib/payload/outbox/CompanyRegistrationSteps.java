package com.intellibucket.lib.payload.outbox;

public enum CompanyRegistrationSteps implements ProcessNameReference {
    ON_STARTED_STEP, COMPANY_PROFILE_CREATING_STEP, IMAGE_PROCESSING_STEP;

    public String getProcessName() {
        return "COMPANY_REGISTRATION";
    }
}
