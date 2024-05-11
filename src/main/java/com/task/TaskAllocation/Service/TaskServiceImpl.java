package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TaskDTO;
import com.task.TaskAllocation.Entities.Task;
import com.task.TaskAllocation.Entities.TeamMembers;
import com.task.TaskAllocation.Repository.TaskRepository;
import com.task.TaskAllocation.Repository.TeamMembersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TeamMembersRepository teamMembersRepository;

    @Transactional
    public boolean createTask(TaskDTO taskDTO) {
        Task task  = new Task();
        taskDTO.setId(0);
        BeanUtils.copyProperties(taskDTO,task);
        Optional<TeamMembers> teamMembers = teamMembersRepository.findById(taskDTO.getTeamMembers().getId());
        if (teamMembers.isPresent()){
            task.setTeamMembers(teamMembers.get());
        } else{
            throw new EntityNotFoundException("Team Members not found for the given ID : " + taskDTO.getTeamMembers().getId());
        }
        Task task2 = taskRepository.save(task);
        return taskDTO.getId() != task2.getId();

    }

    @Transactional
    public boolean updateTask(TaskDTO taskDTO) {
        Task task  = new Task();
        taskDTO.setId(0);
        BeanUtils.copyProperties(taskDTO,task);
        Optional<TeamMembers> teamMembers = teamMembersRepository.findById(taskDTO.getTeamMembers().getId());
        if (teamMembers.isPresent()){
            task.setTeamMembers(teamMembers.get());
        } else{
            throw new EntityNotFoundException("Team Members not found for the given ID : " + taskDTO.getTeamMembers().getId());
        }
        Task task2 = taskRepository.save(task);
        return taskDTO.getId() == task2.getId();
    }

    @Transactional
    public boolean deleteTask(long id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return  false;
    }

    @Transactional(readOnly = true)
    public TaskDTO getTask(long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            TaskDTO taskDTO = new TaskDTO();
            BeanUtils.copyProperties(task, taskDTO);
            Optional<TeamMembers> teamMembers = teamMembersRepository.findById(task.getTeamMembers().getId());
            if (teamMembers.isPresent()){
                taskDTO.setTeamMembers(teamMembers.get());
            } else{
                throw new EntityNotFoundException("Team Members not found for the given ID : " + task.getTeamMembers().getId());
            }
            return taskDTO;
        }
        return null;
    }
}
