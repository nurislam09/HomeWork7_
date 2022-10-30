package peaksoft.dao.daoimpl;

import jakarta.persistence.EntityManager;
import peaksoft.dao.LessonDao;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import util.Util;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
    static final EntityManager entityManager = Util.getConnection();

    @Override
    public void saveLesson(Lesson lesson, Long course_ID) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_ID);
        course.getLessons().add(lesson);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("SAVE LESSON SUCCESSFULLY WORK!");

    }

    @Override
    public void updateLesson(Long ID, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, ID);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.refresh(lesson1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("UPDATE LESSON SUCCESSFULLY WORK!");

    }

    @Override
    public Lesson getLessonByID(Long ID) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET LESSON BY ID SUCCESSFULLY WORK!");
        return lesson;
    }

    @Override
    public List<Lesson> getLessonBYCourseID(Long course_ID) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET ALL LESSON BY COURSE ID SUCCESSFULLY WORK!");
        return course.getLessons();
    }
}
