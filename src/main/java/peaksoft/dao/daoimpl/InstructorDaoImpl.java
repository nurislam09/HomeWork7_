package peaksoft.dao.daoimpl;

import jakarta.persistence.EntityManager;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import util.Util;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateInstructor(Long ID, Instructor instructor) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, ID);
        instructor1.setName(instructor.getName());
        instructor1.setSurname(instructor.getSurname());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.refresh(instructor1);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Instructor getInstructorByID(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET INSTRUCTOR SUCCESSFULLY! ");
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorByCourseID(Long course_ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (course.getInstructors() == null) {
            System.err.println("THIS ARRAYLIST IS EMPTY!");
        }
        System.out.println("DET ALL INSTRUCTORS SUCCESSFULLY!");

        return course.getInstructors();
    }

    @Override
    public void deleteInstructorByID(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, ID);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignInstructorToCourse(Long instructor_ID, Long course_ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructor_ID);
        Course course = entityManager.find(Course.class, course_ID);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.persist(instructor);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
