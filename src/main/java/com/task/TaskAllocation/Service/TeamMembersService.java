package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TeamMembersDTO;
import java.util.List;

public  interface TeamMembersService {
    boolean createTeamMembers(TeamMembersDTO teamMembersDTO);
    boolean updateTeamMembers(TeamMembersDTO teamMembersDTO);
    boolean deleteTeamMembers(long id);
    TeamMembersDTO getTeamMembers(long id);
    List<TeamMembersDTO> getAllTeamMembers();
}
