package peaksoft.dao.daoimpl;

import jakarta.persistence.EntityManager;
import peaksoft.dao.TaskDao;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import util.Util;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    @Override
    public void saveTask(Task task) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateTask(Long ID, Task task) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, ID);
        task1.setName(task.getName());
        task1.setDeadLine(task.getDeadLine());
        task1.setTask(task.getTask());
        entityManager.refresh(task1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Task> getAllTaskBYLessonID(Long lesson_ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lesson_ID);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("GET ALL TASKS SUCCESSFULLY WORK!");
        return lesson.getTasks();
    }

    @Override
    public void deleteTaskByID(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, ID);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
