package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.*;

@Entity
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
    private Integer phonenumber;

    @Column(name = "cv_id")
    private Integer cvId;

    @Column(name = "candidatestatusid", nullable = false)
    private Integer candidatestatusid;

    @Column(name = "companyid")
    private Integer companyid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getCandidatestatusid() {
        return candidatestatusid;
    }

    public void setCandidatestatusid(Integer candidatestatusid) {
        this.candidatestatusid = candidatestatusid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

}