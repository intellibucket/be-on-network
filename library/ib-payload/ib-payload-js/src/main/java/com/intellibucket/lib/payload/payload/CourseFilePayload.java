package com.intellibucket.lib.payload.payload;

import com.intellibucket.lib.payload.event.create.CourseFileEvent;

import java.util.UUID;

public class CourseFilePayload extends Payload{
    UUID courseId;

    public CourseFilePayload(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public static CourseFilePayload of(UUID courseId){
        return new CourseFilePayload(courseId);
    }
}
