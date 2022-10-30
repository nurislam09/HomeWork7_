package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.dao.daoimpl.CourseDaoImpl;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private static final CourseDaoImpl courseDao = new CourseDaoImpl();

    @Override
    public void saveCourse(Course course) {
        try {
            courseDao.saveCourse(course);
            System.out.println("COURSE SAVED SUCCESSFULLY!");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Course getCourseById(Long ID) {
        try {
            return courseDao.getCourseByID(ID);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getAllCourse() {
        try {
            return courseDao.getAllCourse();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCourse(Long id, Course course) {
        try {
            courseDao.updateCourse(id, course);
            System.out.println("Course updated successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCourseById(Long ID) {
        try {
            courseDao.deleteCourseByID(ID);
            System.out.println("COURSE SUCCESSFULLY DELETED!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course getCourseByName(String name) {
        try {
            return courseDao.getCourseByName(name);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

}
