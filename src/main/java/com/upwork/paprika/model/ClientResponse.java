package com.upwork.paprika.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private boolean status;
    private String message;
    private ResultObject result;
}