package com.hoodzie.springbootstart.filtering.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonFilter("FilterDtoFilter")
//@JsonIgnoreProperties({"field1", "field2"})  Multiple fields are ignored
public class FilterDTO {

    // @JsonIgnore prevent returning this specific field
    private String field1;
    private String field2;
    private String field3;
}
