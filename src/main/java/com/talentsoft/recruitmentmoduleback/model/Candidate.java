package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "offer_id", nullable = false)
    private Integer offerId;

    @Column(name = "surname", length = 45)
    private String surname;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "cv_id")
    private Integer cvId;

    @Column(name = "candidatestatusid", nullable = false)
    private Integer candidateStatusId;

    @Column(name = "companyid")
    private Integer companyid;
}