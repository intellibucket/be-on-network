package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class CourseUpdatedPayload extends Payload{
    private UUID courseId;

    public CourseUpdatedPayload(UUID courseId) {
        this.courseId = courseId;
    }

    public CourseUpdatedPayload() {
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
    public static CourseUpdatedPayload of(UUID courId){
        return new CourseUpdatedPayload(courId);
    }
}
