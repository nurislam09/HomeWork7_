package peaksoft;

import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.CourseService;
import peaksoft.service.serviceimpl.CourseServiceImpl;
import peaksoft.service.serviceimpl.InstructorServiceImpl;
import peaksoft.service.serviceimpl.LessonServiceImpl;
import peaksoft.service.serviceimpl.TaskServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CourseServiceImpl courseService = new CourseServiceImpl();
        InstructorServiceImpl instructorService = new InstructorServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();

        Course course = new Course("Peaksoft House", "9 week", LocalDate.of(2020, 1, 27), "https://www.instagram.com/reel/Cjp89bcIpQR/?utm_source=ig_web_copy_link",
                "бул PeakSoft ITкомпаниясынын онлайн жана офлайн окутуу курстары. Биз талап кылынган Back-end (Java) жана Front-end (JavaScript), IT адистерин online - offline даярдайбыз. Нолдон баштап биринчи жумуш күнүнө чейин.");

        Instructor instructor1 = new Instructor("Muhammed", "Alanov", "Alanov@gamil.com",
                "+996555558967");
        Instructor instructor2 = new Instructor("Aida", "Rahmat", "rahmat@gamil.com"
                , "+996202252525");

        Lesson lesson = new Lesson("Java", "https://us02web.zoom.us/rec/share/m0bRKd2_kOuk-Oib1LCFIkBpF5HQdBdxthwGQC9pLJN8FgB3oK3T1HWfiW51tIzM.jpp5S2LnexB-umBA");

        Task task = new Task("Query", "1 week", "Hibernate");


        //courseService.saveCourse(course);

      //  instructorService.saveInstructor(instructor1);

        //instructorService.assignInstructorToCourse(1L,1L);


        // lessonService.saveLesson(lesson,1L);

        taskService.saveTask(task);


    }
}
