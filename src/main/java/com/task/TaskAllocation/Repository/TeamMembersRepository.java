package com.task.TaskAllocation.Repository;

import com.task.TaskAllocation.Entities.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Long> {


    Optional<TeamMembers> findById(Long id);
}
