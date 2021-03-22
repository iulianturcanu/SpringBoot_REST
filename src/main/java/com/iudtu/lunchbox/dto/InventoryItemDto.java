package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.iudtu.lunchbox.model.LunchboxItem;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class InventoryItemDto {

    private Long id;
    private Integer count;
    private LunchboxItem item;
}
