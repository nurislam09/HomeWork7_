package peaksoft.dao;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long ID, Instructor instructor);

    Instructor getInstructorByID(Long ID);

    List<Instructor> getInstructorByCourseID(Long course_ID);

    void deleteInstructorByID(Long ID);

    void assignInstructorToCourse(Long instructor_ID, Long course_ID);

}
