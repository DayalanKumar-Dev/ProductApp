package com.product.app.event;

import com.product.app.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductEvent {

    private Integer productEventId;
    private ProductEventType productEventType;
    private Product product;
}
