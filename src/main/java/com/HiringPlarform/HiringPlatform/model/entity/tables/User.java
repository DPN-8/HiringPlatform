package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "user_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;

   @Email
   @Column(unique = true)
   private String email;

   private String name;

   private String password;
   private String collegeName;

   @Enumerated(EnumType.STRING)
   private Role role;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "contest_user_table",
           joinColumns = {
                   @JoinColumn(name = "user_id")
           },
           inverseJoinColumns = {
                   @JoinColumn(name = "contest_id")
           }
   )
   private List<Contest> contest;

   @OneToOne(mappedBy = "user")
   private Resume resume;

}
