package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.iudtu.lunchbox.model.LunchboxItem;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LunchboxDto {
    private Long id;
    private String owner;
    private String description;
    private Integer capacity;
    private List<LunchboxItem> lunchboxItemsList;

}
