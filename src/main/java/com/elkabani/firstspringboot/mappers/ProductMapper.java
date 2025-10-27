package com.elkabani.firstspringboot.mappers;

import com.elkabani.firstspringboot.dtos.ProductDto;
import com.elkabani.firstspringboot.entities.Category;
import com.elkabani.firstspringboot.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", expression = "java(categoryFromId(dto.getCategoryId()))")
    Product toEntity(ProductDto dto);

    void update(ProductDto dto, @MappingTarget Product product);

    default Category categoryFromId(Integer id) {
        if (id == null) return null;
        Category c = new Category();
        c.setId(id);
        return c;
    }

}
