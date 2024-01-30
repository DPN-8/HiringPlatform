package com.HiringPlarform.HiringPlatform.model.entity.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mcq_image")
@Entity
public class McqImageUrl {

    @Id
    private String imageUrlId;

    private String imageUrl;
}
