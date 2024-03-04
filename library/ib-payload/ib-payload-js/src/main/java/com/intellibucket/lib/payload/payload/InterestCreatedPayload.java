package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class InterestCreatedPayload extends Payload{

    private UUID interestId;

    public InterestCreatedPayload(UUID interestId){
        this.interestId = interestId;
    }

    public InterestCreatedPayload(){}

    public UUID getInterestId() {
        return interestId;
    }

    public void setInterestId(UUID interestId) {
        this.interestId = interestId;
    }

    public static InterestCreatedPayload of(UUID interestId) {
        return new InterestCreatedPayload(interestId);
    }
}
