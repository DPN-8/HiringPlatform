package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.enums.AOI;
import com.HiringPlarform.HiringPlatform.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;

   @Email
   @Column(unique = true)
   private String email;

   private String password;

   @Enumerated(EnumType.STRING)
   private Role role;

   @Enumerated(EnumType.STRING)
   private AOI areaOfInterest;

   @ManyToOne
   @JoinColumn(name = "contest_id")
   private Contest contest;

   private int yearOfExperience;
}
