package com.talentsoft.recruitmentmoduleback.DTO.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferUpdateStatusRequest {
    private String status;
}
