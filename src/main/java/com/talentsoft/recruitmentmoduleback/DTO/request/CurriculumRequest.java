package com.talentsoft.recruitmentmoduleback.DTO.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CurriculumRequest {
    private String address;
    private String personalObjetive;
    private Integer workexperience;
    private String educationalhistory;
    private String language;
    private String certification;
    private String personalreference;
    private String university;
    private String career;
}
