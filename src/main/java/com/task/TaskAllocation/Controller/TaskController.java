package com.task.TaskAllocation.Controller;

import com.task.TaskAllocation.DTO.TaskDTO;
import com.task.TaskAllocation.Enum.RestApiResponseStatus;
import com.task.TaskAllocation.Service.TaskService;
import com.task.TaskAllocation.Util.EndPointBundle;
import com.task.TaskAllocation.Util.ResponseWrapper;
import com.task.TaskAllocation.Util.ValidationMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndPointBundle.TASK)
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<ResponseWrapper<TaskDTO>> createTask (@RequestBody @Valid
                                                                    TaskDTO taskDTO){
        if (taskService.createTask(taskDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Created, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @PutMapping(EndPointBundle.update)
    public ResponseEntity<ResponseWrapper<TaskDTO>> updateTeamMembers (@PathVariable ("id") Long id,@RequestBody @Valid TaskDTO taskDTO) {
        taskDTO.setId(id);
        if (taskService.updateTask(taskDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body( new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Updated, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @GetMapping(EndPointBundle.GET)
    public ResponseEntity<ResponseWrapper<TaskDTO>> getTeamMembers (@PathVariable ("id") Long id) {
        TaskDTO taskDTO = taskService.getTask(id);
        if ( taskDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.RETRIEVED.getStatusCode(),
                    ValidationMessages.Retrieved, taskDTO));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.NOT_FOUND.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @DeleteMapping(EndPointBundle.delete)
    public ResponseEntity<ResponseWrapper<TaskDTO>> deleteTeamMembers (@PathVariable ("id") Long id ) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.DELETED.getStatusCode(),
                    ValidationMessages.Deleted, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @GetMapping(EndPointBundle.GETALL)
    public ResponseEntity<ResponseWrapper<List<TaskDTO>>> getAllTasks () {
        List<TaskDTO> taskDTOS = taskService.getAllTasks();
        if( taskDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Retrieved, taskDTOS));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper<>(RestApiResponseStatus.NOT_FOUND.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

}