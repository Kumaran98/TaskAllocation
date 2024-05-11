package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TeamMembersDTO;

public  interface TeamMembersService {
    boolean createTeamMembers(TeamMembersDTO teamMembersDTO);
    boolean updateTeamMembers(TeamMembersDTO teamMembersDTO);
    boolean deleteTeamMembers(long id);
    TeamMembersDTO getTeamMembers(long id);
}
