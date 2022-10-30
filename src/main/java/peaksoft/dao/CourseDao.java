package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    void saveCourse(Course course);

    Course getCourseByID(Long ID);

    List<Course> getAllCourse();

    void updateCourse(Long ID, Course course);

    void deleteCourseByID(Long ID);

    Course getCourseByName(String name);

}
