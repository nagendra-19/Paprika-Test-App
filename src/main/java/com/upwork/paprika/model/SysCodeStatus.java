package com.upwork.paprika.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysCodeStatus {
    @JsonProperty(value = "ST_CODE")
    private String ST_CODE;
    @JsonProperty(value = "ST_DESC")
    private String ST_DESC;
}
