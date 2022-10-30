package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.dao.daoimpl.LessonDaoImpl;
import peaksoft.entity.Lesson;
import peaksoft.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDaoImpl lessonDao = new LessonDaoImpl();
    @Override
    public void saveLesson(Lesson lesson, Long course_ID) {
        try {
            lessonDao.saveLesson(lesson, course_ID);
            System.out.println("SAVE LESSON SUCCESSFULLY!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateLesson(Long ID, Lesson lesson) {
        try {
            lessonDao.updateLesson(ID, lesson);
            System.out.println("UPDATE LESSON SUCCESSFULLY");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lesson getLessonById(Long ID) {
        try {
            return lessonDao.getLessonByID(ID);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long course_ID) {
        try {
            return lessonDao.getLessonBYCourseID(course_ID);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
