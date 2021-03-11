package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LunchboxDto {
    private String owner;
    private String description;
    private Integer capacity;
    private List<LunchboxItemDto> lunchboxItemsList;
}
