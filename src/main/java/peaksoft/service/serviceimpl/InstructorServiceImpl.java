package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.dao.daoimpl.InstructorDaoImpl;
import peaksoft.entity.Instructor;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private static final InstructorDaoImpl instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            instructorDao.saveInstructor(instructor);
            System.out.println("Instructor saved successfully!");
        } catch(HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateInstructor(Long ID, Instructor instructor) {
        try {
            instructorDao.updateInstructor(ID, instructor);
            System.out.println("INSTRUCTOR UPDATE SUCCESSFULLY!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Instructor getInstructorById(Long ID) {
        try {
            return instructorDao.getInstructorByID(ID);
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long course_ID) {
        try {
            return instructorDao.getInstructorByCourseID(course_ID);
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteInstructorById(Long ID) {
        try {
            instructorDao.deleteInstructorByID(ID);
            System.out.println("INSTRUCTOR SUCCESSFULLY DELETED!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void assignInstructorToCourse(Long instructor_ID, Long course_ID) {
        try {
            instructorDao.assignInstructorToCourse(instructor_ID, course_ID);
            System.out.println("INSTRUCTOR AND COURSE ASSIGN SUCCESSFULLY!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }
}
