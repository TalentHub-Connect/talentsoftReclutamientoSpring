package com.talentsoft.recruitmentmoduleback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidatestatus")
public class Candidatestatus {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = 45)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}