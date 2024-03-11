package com.upwork.paprika.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessUnit {
    @JsonProperty(value = "BU_MN")
    private Integer BU_MN;
    @JsonProperty(value = "BU_REF")
    private String BU_REF;
    @JsonProperty(value = "BU_DESC")
    private String BU_DESC;
}
