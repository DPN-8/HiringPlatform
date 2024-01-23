package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_table")
@Data
@Builder
public class Category{

    @Id
    @GeneratedValue
    private int categoryId;

    private String category;
}
