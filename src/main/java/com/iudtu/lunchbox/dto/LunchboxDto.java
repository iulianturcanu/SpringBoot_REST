package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LunchboxDto {
    private Long id;
    private String owner;
    private String description;
    private Integer capacity;
    private List<LunchboxItemDto> lunchboxItemsList;
    private Long itemId;
}
