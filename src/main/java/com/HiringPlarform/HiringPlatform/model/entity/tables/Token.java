package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "token_table")
public class Token {

    @Id
    private Long id;

    private String userId;
    private String token;
    private boolean revoked;
    private boolean expired;
}
