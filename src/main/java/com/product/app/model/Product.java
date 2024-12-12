package com.product.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @NotNull
    private Integer productId;

    @NotBlank
    private String productName;

    @NotBlank
    private String productManufacturerName;
}
