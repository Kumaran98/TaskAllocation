package com.task.TaskAllocation.DTO;

import com.task.TaskAllocation.Entities.TeamMembers;
import com.task.TaskAllocation.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private long id;
    private TeamMembers teamMembers;
    private String description;
    private Status status;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
