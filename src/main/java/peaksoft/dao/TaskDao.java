package peaksoft.dao;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Task task);

    void updateTask(Long ID, Task task);

    List<Task> getAllTaskBYLessonID(Long lesson_ID);

    void deleteTaskByID(Long ID);
}
