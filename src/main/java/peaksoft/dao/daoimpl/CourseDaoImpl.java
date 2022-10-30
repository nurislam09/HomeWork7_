package peaksoft.dao.daoimpl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;
import util.Util;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void saveCourse(Course course) {
        try {
            EntityManager entityManager = Util.getConnection();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Course getCourseByID(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET COURSE BY ID SUCCESSFULLY!");
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        List courses = entityManager.createQuery("select  c from Course c").getResultList();
        entityManager.close();
        System.out.println("GET ALL COURSES SUCCESSFULLY!");
        return courses;
    }

    @Override
    public void updateCourse(Long ID, Course course) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, ID);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCreateAt(course.getCreateAt());
        course1.setImageLink(course.getImageLink());
        course1.setDescription(course.getDescription());
        entityManager.merge(course1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCourseByID(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, ID);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("COURSE SUCCESSFULLY DELETED ! ");
    }

    @Override
    public Course getCourseByName(String name) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, name);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET COURSE BY NAME SUCCESSFULLY!");
        return null;
    }
}
