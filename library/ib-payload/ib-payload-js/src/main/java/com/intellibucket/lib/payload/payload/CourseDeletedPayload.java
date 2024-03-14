package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class CourseDeletedPayload extends Payload{
    private UUID courseId;

    public CourseDeletedPayload(UUID courseId) {
        this.courseId = courseId;
    }

    public CourseDeletedPayload() {}
    public UUID getCourseId() {
        return courseId;
    }
    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public static CourseDeletedPayload of(UUID courseId) {
        return new CourseDeletedPayload(courseId);
    }

}
