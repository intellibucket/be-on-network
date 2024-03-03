package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class CourseCreatedPayload extends Payload{
    private UUID courseId;
    public CourseCreatedPayload(UUID courseId){
        this.courseId = courseId;
    }
    public CourseCreatedPayload(){}
    public UUID getCourseId() {
        return courseId;
    }
    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public static CourseCreatedPayload of(UUID courseId) {
        return new CourseCreatedPayload(courseId);
    }
}
