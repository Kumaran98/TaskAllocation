package com.task.TaskAllocation.Entities;

import com.task.TaskAllocation.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teamMembers")
public class Task  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "teamMembers_id")
    private TeamMembers teamMembers;
    private String description;
    private Status status;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}

