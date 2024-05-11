package com.task.TaskAllocation.Controller;
import com.task.TaskAllocation.DTO.TeamMembersDTO;
import com.task.TaskAllocation.Enum.RestApiResponseStatus;
import com.task.TaskAllocation.Service.TeamMembersService;
import com.task.TaskAllocation.Util.EndPointBundle;
import com.task.TaskAllocation.Util.ResponseWrapper;
import com.task.TaskAllocation.Util.ValidationMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(EndPointBundle.TEAMMEMBERS)
public class TeamMembersController {
    @Autowired
    TeamMembersService teamMembersService;

    @PostMapping
    public ResponseEntity<ResponseWrapper<TeamMembersDTO>> createTeamMembers (@RequestBody @Valid
    TeamMembersDTO teamMembersDTO){
        if (teamMembersService.createTeamMembers(teamMembersDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Created, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @PutMapping(EndPointBundle.update)
    public ResponseEntity<ResponseWrapper<TeamMembersDTO>> updateTeamMembers (@PathVariable ("id") Long id,@RequestBody @Valid TeamMembersDTO teamMembersDTO) {
        teamMembersDTO.setId(id);
        if (teamMembersService.updateTeamMembers(teamMembersDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body( new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Updated, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @GetMapping(EndPointBundle.GET)
    public ResponseEntity<ResponseWrapper<TeamMembersDTO>> getTeamMembers (@PathVariable ("id") Long id) {
        TeamMembersDTO teamMembersDTO = teamMembersService.getTeamMembers(id);
        if ( teamMembersDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.RETRIEVED.getStatusCode(),
                    ValidationMessages.Retrieved, teamMembersDTO));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.NOT_FOUND.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @DeleteMapping(EndPointBundle.delete)
    public ResponseEntity<ResponseWrapper<TeamMembersDTO>> deleteTeamMembers (@PathVariable ("id") Long id ) {
        if (teamMembersService.deleteTeamMembers(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.DELETED.getStatusCode(),
                    ValidationMessages.Deleted, null));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }

    @GetMapping(EndPointBundle.GETALL)
    public ResponseEntity<ResponseWrapper<List<TeamMembersDTO>>> getAllTeamMembers () {
        List<TeamMembersDTO> teamMembersDTOS = teamMembersService.getAllTeamMembers();
        if (teamMembersDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(RestApiResponseStatus.OK.getStatusCode(),
                    ValidationMessages.Retrieved, teamMembersDTOS));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper<>(RestApiResponseStatus.NOT_FOUND.getStatusCode(),
                ValidationMessages.BadRequest, null));
    }
}
