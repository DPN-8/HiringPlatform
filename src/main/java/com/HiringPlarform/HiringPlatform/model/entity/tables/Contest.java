package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.ContestStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "contest_table")
public class Contest {

    @Id
    private String contestId;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ContestStatus contestStatus;

    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contest")
    private List<Rounds> rounds;

    @ManyToMany(mappedBy = "contest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contest")
    private List<User> users;

    @ManyToMany(mappedBy = "contest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contest")
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Contest{" +
                "contestId='" + contestId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contestStatus=" + contestStatus +
                '}';
    }
}