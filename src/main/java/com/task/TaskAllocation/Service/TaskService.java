package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TaskDTO;

import java.util.List;

public interface TaskService {
    boolean createTask (TaskDTO taskDTO);
    boolean updateTask (TaskDTO taskDTO);
    boolean deleteTask (long id);
    TaskDTO getTask (long id);
    List<TaskDTO> getAllTasks();
}
