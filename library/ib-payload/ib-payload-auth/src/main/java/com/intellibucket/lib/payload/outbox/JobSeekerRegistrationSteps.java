package com.intellibucket.lib.payload.outbox;

public enum JobSeekerRegistrationSteps implements ProcessNameReference {
    ON_STARTED_STEP, JOB_SEEKER_PROFILE_CREATING_STEP;

    public String getProcessName() {
        return "JOB_SEEKER_REGISTRATION";
    }
}
