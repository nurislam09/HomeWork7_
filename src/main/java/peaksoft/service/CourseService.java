package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course course);

    Course getCourseById(Long ID);

    List<Course> getAllCourse();

    void updateCourse(Long ID, Course course);

    void deleteCourseById(Long ID);

    Course getCourseByName(String name);
}
