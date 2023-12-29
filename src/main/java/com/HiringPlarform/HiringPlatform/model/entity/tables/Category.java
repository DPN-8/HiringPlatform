package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catogory_table")
@Data
public class Category{

    @Id
    private int categoryId;

    private String category;
}
