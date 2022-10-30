package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.dao.daoimpl.TaskDaoImpl;
import peaksoft.entity.Task;
import peaksoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl  implements TaskService {
    private static final TaskDaoImpl taskd = new TaskDaoImpl();

    @Override
    public void saveTask(Task task) {
        try {
            taskd.saveTask(task);
            System.out.println("TASK saved SUCCESSFULLY!");
        }catch (HibernateException e){
            throw  new RuntimeException();

        }
    }

    @Override
    public void updateTask(Long ID, Task task) {
     try {
         taskd.updateTask(ID,task);
     }catch (HibernateException e){
         throw new RuntimeException();
     }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lesson_ID) {
        try {
            return taskd.getAllTaskBYLessonID(lesson_ID);
        }catch (HibernateException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteTaskById(Long lesson_ID) {
     try {
         taskd.deleteTaskByID(lesson_ID);
         System.out.println("TASK DELETE SUCCESSFULLY!");
     }catch (HibernateException e){
         throw  new RuntimeException();
     }
    }
}
