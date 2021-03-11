package com.iudtu.lunchbox.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LunchboxDto {
    private String owner;
    private String description;
    private Integer capacity;
    private List<LunchboxItemDto> lunchboxItemsList;
}
