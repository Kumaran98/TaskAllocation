package com.task.TaskAllocation.Service;

import com.task.TaskAllocation.DTO.TeamMembersDTO;
import com.task.TaskAllocation.Entities.TeamMembers;
import com.task.TaskAllocation.Repository.TeamMembersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMembersServiceImpl implements TeamMembersService{

    @Autowired
    TeamMembersRepository teamMembersRepository;

    @Transactional
    public boolean createTeamMembers(TeamMembersDTO teamMembersDTO) {
        TeamMembers teamMembers = new TeamMembers();
        teamMembersDTO.setId(0);
        BeanUtils.copyProperties(teamMembersDTO, teamMembers);
        TeamMembers teamMembers1 = teamMembersRepository.save(teamMembers);
        return teamMembers1.getId() != teamMembersDTO.getId();
    }

    @Transactional
    public boolean updateTeamMembers(TeamMembersDTO teamMembersDTO) {
        TeamMembers teamMembers = new TeamMembers();
        teamMembersDTO.setId(0);
        BeanUtils.copyProperties(teamMembersDTO, teamMembers);
        TeamMembers teamMembers1 = teamMembersRepository.save(teamMembers);
        return teamMembers1.getId() == teamMembersDTO.getId();
    }

    @Transactional
    public boolean deleteTeamMembers(long id) {
        if (teamMembersRepository.findById(id).isPresent()) {
            teamMembersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public TeamMembersDTO getTeamMembers(long id) {
        if (teamMembersRepository.findById(id).isPresent()) {
            TeamMembers teamMembers = teamMembersRepository.findById(id).get();
            TeamMembersDTO teamMembersDTO = new TeamMembersDTO();
            BeanUtils.copyProperties(teamMembers, teamMembersDTO);
            return teamMembersDTO;
        }
        return null;
    }

    @Transactional
    public List<TeamMembersDTO> getAllTeamMembers() {
        List<TeamMembers> teamMembersList = teamMembersRepository.findAll();
        List<TeamMembersDTO> teamMembersDTOS = new ArrayList<>();
        for (TeamMembers teamMembers: teamMembersList){
            TeamMembersDTO teamMembersDTO = new TeamMembersDTO();
            BeanUtils.copyProperties(teamMembers, teamMembersDTO);
            teamMembersDTOS.add(teamMembersDTO);
        }
        return teamMembersDTOS;
    }
}
