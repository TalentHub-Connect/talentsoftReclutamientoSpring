package com.talentsoft.recruitmentmoduleback.DTO;

public class CandidateDTO {

    private final String status;
    private final Integer phonenumber;

    public String getStatus() {
        return status;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public CandidateDTO(String status, Integer phonenumber) {
        this.status = status;
        this.phonenumber = phonenumber;
    }


}
