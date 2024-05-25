package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "personalobjetive", length = 45)
    private String personalobjetive;

    @Column(name = "workexperience")
    private Integer workexperience;

    @Column(name = "educationalhistory", length = 45)
    private String educationalhistory;

    @Column(name = "language", length = 45)
    private String language;

    @Column(name = "certification", length = 45)
    private String certification;

    @Column(name = "personalreference", length = 45)
    private String personalreference;

    @Column(name = "university", length = 45)
    private String university;

    @Column(name = "career", length = 45)
    private String career;

}