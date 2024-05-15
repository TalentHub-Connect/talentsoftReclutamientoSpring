package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittleoffer() {
        return tittleoffer;
    }

    public void setTittleoffer(String tittleoffer) {
        this.tittleoffer = tittleoffer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(String requeriments) {
        this.requeriments = requeriments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

}