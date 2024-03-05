package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class ContactDeletePayload extends Payload{
    private UUID courseId;
    public ContactDeletePayload(UUID courseId){
        this.courseId = courseId;
    }
    public ContactDeletePayload(){}
    public UUID getContactId() {
        return courseId;
    }
    public void setContactId(UUID courseId) {
        this.courseId = courseId;
    }

    public static ContactDeletePayload of(UUID courseId) {
        return new ContactDeletePayload(courseId);
    }
}
