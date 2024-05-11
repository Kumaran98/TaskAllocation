package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TaskDTO;

public interface TaskService {
    boolean createTask (TaskDTO taskDTO);
    boolean updateTask (TaskDTO taskDTO);
    boolean deleteTask (long id);
    TaskDTO getTask (long id);

}
