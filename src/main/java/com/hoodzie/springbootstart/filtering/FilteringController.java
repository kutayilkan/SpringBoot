package com.hoodzie.springbootstart.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hoodzie.springbootstart.filtering.model.FilterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hoodzie.springbootstart.core.ProjectUtils;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("filtering")
@Tag(name = "Filtering", description = "Spring Boot Static (@JsonIgnore/@JsonIngoreProperties) & Dynamic(@JsonFilter) Filtering")
public class FilteringController {

    @GetMapping
    @Operation(description = "Except field2 filtered")
    public MappingJacksonValue filter() {
        FilterDTO dto = FilterDTO.builder().field1("a").field2("b").field3("c").build();

        return ProjectUtils.filterDTO(dto, "FilterDtoFilter", "field2", "field3");
    }

    @GetMapping("list")
    @Operation(description = "Except field2, field3 filtered")
    public MappingJacksonValue filterList() {
        List<FilterDTO> list = Arrays.asList(
                FilterDTO.builder().field1("a").field2("b").field3("c").build(),
                FilterDTO.builder().field1("d").field2("e").field3("f").build(),
                FilterDTO.builder().field1("g").field2("h").field3("i").build()
        );

        return ProjectUtils.filterDTO(list, "FilterDtoFilter", "field2", "field3");
    }


}
