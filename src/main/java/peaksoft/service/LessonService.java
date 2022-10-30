package peaksoft.service;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Lesson lesson, Long course_ID);

    void updateLesson(Long ID, Lesson lesson);

    Lesson getLessonById(Long ID);

    List<Lesson> getLessonsByCourseId(Long course_ID);
}
