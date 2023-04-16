package com.saru.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    @NotNull(message = "Product name should not be null or empty")
    @Size(min = 2,max =100,message = "Product name should be at least 2 characters")
    private String productName;

    @Min(value = 0,message = "Price should be greater than 0")
    private Double price;

    @NotNull(message = "Product description should not be null or empty")
    @Size(min = 2,max =100,message = "Product description should be at least 2 characters")
    private String description;

    @NotNull(message = "Product skuCode should not be null or empty")
    @Size(min = 6,max =10,message = "Product name should be at least 6 characters")
    private String skuCodes;

    @Min(value = 0,message = "Quantity should be greater than 0")
    private Integer quantity;
}
