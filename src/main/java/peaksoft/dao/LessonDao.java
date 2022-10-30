package peaksoft.dao;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonDao {
    void saveLesson(Lesson lesson, Long course_ID);

    void updateLesson(Long ID, Lesson lesson);

    Lesson getLessonByID(Long ID);

    List<Lesson> getLessonBYCourseID(Long course_ID);

}
