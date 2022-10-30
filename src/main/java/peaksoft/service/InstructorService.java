package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long ID, Instructor instructor);

    Instructor getInstructorById(Long ID);

    List<Instructor> getInstructorsByCourseId(Long course_ID);

    void deleteInstructorById(Long ID);

    void assignInstructorToCourse(Long instructor_ID, Long course_ID);
}
