package com.HiringPlarform.HiringPlatform.model.entity.tables;

import com.HiringPlarform.HiringPlatform.model.entity.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.HTML;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "coding_table")
public class CodingQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long questionId;

    @Column(length = 1000)
    private String question;

    @OneToMany
    @JoinColumn(name = "Id")
    private List<CodingImageUrl> imageUrl;

    @OneToMany(mappedBy = "codingQuestion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cases> casesList;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(length = 500)
    private String explanation;

    @Column(length = 200)
    private String constraints;

    @Column(length = 500)
    private String inputFormat;

    @Column(length = 500)
    private String outputFormat;
}
