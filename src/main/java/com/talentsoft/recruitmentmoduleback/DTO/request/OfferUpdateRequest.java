package com.talentsoft.recruitmentmoduleback.DTO.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferUpdateRequest {
    private String status;
    private String tittleOffer;
    private String description;
    private String requirements;
}
