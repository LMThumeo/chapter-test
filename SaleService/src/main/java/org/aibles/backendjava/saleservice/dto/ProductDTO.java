package org.aibles.backendjava.saleservice.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Integer id;

    private String name;

    private String origin;

    private Integer price;

    private Integer quantity;
}
