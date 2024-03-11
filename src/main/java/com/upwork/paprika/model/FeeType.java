package com.upwork.paprika.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeType {

    @JsonProperty(value = "FEE_CODE")
    private String feeCode;
    @JsonProperty(value = "FEE_DESC")
    private String feeDesc;
}
