package com.project.sihcalci.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParameterRequest {
    private String name;
    private Integer maxMarks;
}
