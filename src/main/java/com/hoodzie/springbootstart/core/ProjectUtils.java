package com.hoodzie.springbootstart.core;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class ProjectUtils {

    public static MappingJacksonValue filterDTO(Object filterObject, String classFilterName, String... propertyArray){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterObject);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(classFilterName, filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
