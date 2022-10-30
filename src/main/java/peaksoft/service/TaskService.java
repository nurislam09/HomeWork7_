package peaksoft.service;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Task task);

    void updateTask(Long ID, Task task);

    List<Task> getAllTaskByLessonId(Long lesson_ID);

    void deleteTaskById(Long lesson_ID);
}
