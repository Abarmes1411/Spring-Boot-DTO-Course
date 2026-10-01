package com.example.cursospringapi.cursospringapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.cursospringapi.cursospringapi.dto.CategoryDTO;
import com.example.cursospringapi.cursospringapi.model.Category;

@Component 
public class CategoryMapper {

    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO toDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    

}
