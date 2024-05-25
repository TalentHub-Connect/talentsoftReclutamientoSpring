package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tittleoffer", length = 45)
    private String tittleoffer;

    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "publishdate", length = 15)
    private String publishdate;

    @Column(name = "requeriments", length = 45)
    private String requeriments;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "companyid")
    private Integer companyid;

}