package com.upwork.paprika.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {

    @JsonProperty(value = "JO_MN")
    private String JO_MN;
    @JsonProperty(value = "JO_JOB_KEY")
    private String JO_JOB_KEY;
    @JsonProperty(value = "JO_JOB_TITLE")
    private String JO_JOB_TITLE;
    @JsonProperty(value = "JO_SA_MN")
    private Integer JO_SA_MN;
    @JsonProperty(value = "JO_FEE_TYPE")
    private String JO_FEE_TYPE;
    @JsonProperty(value = "JO_BU_MN")
    private Integer JO_BU_MN;
    @JsonProperty(value = "JO_STATUS")
    private String JO_STATUS;
    @JsonProperty(value = "JO_TEXT_1")
    private String JO_TEXT_1;
    @JsonProperty(value = "JO_TEXT_2")
    private String JO_TEXT_2;
    @JsonProperty(value = "JO_TEXT_3")
    private String JO_TEXT_3;
    @JsonProperty(value = "JO_TEXT_4")
    private String JO_TEXT_4;
    @JsonProperty(value = "JO_NUMBER_1")
    private float JO_NUMBER_1;
    @JsonProperty(value = "JO_NUMBER_2")
    private float JO_NUMBER_2;
    @JsonProperty(value = "JO_NUMBER_3")
    private float JO_NUMBER_3;
    @JsonProperty(value = "JO_NUMBER_4")
    private float JO_NUMBER_4;
    @JsonProperty(value = "JO_DATE_1")
    private LocalDateTime JO_DATE_1;
    @JsonProperty(value = "JO_DATE_2")
    private LocalDateTime JO_DATE_2;
    @JsonProperty(value = "JO_DATE_3")
    private LocalDateTime JO_DATE_3;
    @JsonProperty(value = "JO_DATE_4")
    private LocalDateTime JO_DATE_4;
    @JsonProperty(value = "JO_PROBABILITY")
    private Integer JO_PROBABILITY;
}