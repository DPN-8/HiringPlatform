package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "coding_image_url")
public class CodingImageUrl {

    @Id
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("imageUrl")
    private CodingQuestion codingQuestion;

    private String url;
}
