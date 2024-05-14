package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalobjetive() {
        return personalobjetive;
    }

    public void setPersonalobjetive(String personalobjetive) {
        this.personalobjetive = personalobjetive;
    }

    public Integer getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(Integer workexperience) {
        this.workexperience = workexperience;
    }

    public String getEducationalhistory() {
        return educationalhistory;
    }

    public void setEducationalhistory(String educationalhistory) {
        this.educationalhistory = educationalhistory;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getPersonalreference() {
        return personalreference;
    }

    public void setPersonalreference(String personalreference) {
        this.personalreference = personalreference;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

}