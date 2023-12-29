package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inteview_table")
@Data
public class Interview {

    @Id
    private String interviewId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private User employee;

    private String status;

    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;
}
