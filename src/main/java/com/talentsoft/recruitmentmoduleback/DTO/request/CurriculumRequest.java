package com.talentsoft.recruitmentmoduleback.DTO.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
