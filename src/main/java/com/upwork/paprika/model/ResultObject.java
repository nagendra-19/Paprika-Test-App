package com.upwork.paprika.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode()
public class ResultObject {
    List<Client> clients;
    @JsonProperty(value = "Job")
    JobResponse Job;
    @JsonProperty(value = "JO_MN")
    String joMn;
    @JsonProperty(value = "FeeTypes")
    List<FeeType> FeeTypes;
    @JsonProperty(value = "BusinessUnits")
    List<BusinessUnit> BusinessUnits;
    @JsonProperty(value = "Statuses")
    List<SysCodeStatus> Statuses;
}
