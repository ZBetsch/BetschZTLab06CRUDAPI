package com.elkabani.firstspringboot.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private int categoryId;
}
