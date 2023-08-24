package com.intellibukcet.lib.payload.payload;

import az.rock.lib.event.payload.Payload;

import java.util.UUID;

public class ResumeCreatedPayload extends Payload {
    private UUID resumeId;

    public ResumeCreatedPayload(UUID resumeId){
        this.resumeId = resumeId;
    }

    public ResumeCreatedPayload(){}

    public UUID getResumeId() {
        return resumeId;
    }

    public void setResumeId(UUID resumeId) {
        this.resumeId = resumeId;
    }

    public static az.rock.lib.event.payload.js.ResumeCreatedPayload of(UUID resumeId) {
        return new az.rock.lib.event.payload.js.ResumeCreatedPayload(resumeId);
    }
}
