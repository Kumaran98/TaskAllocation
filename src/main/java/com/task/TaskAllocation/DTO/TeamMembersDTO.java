package com.task.TaskAllocation.DTO;

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
public class TeamMembersDTO {
    private long id;
    private String name;
    private String role;
    private String email;

}


