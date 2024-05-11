package com.task.TaskAllocation.Repository;

import com.task.TaskAllocation.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Optional<Task> findById(Long id);
}
