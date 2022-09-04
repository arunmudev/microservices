package com.service.product.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.Cache;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Schema(description = "Product Object")
@Data
@JsonPropertyOrder(value ={"title","price","seller","id"})
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @JsonProperty(value = "id",required = true,index = 10)
    @Schema(description = "unique identifier of product", example = "1",required = true)
    private Long id;

    @Column(name = "productTitle", nullable = false)
    @JsonProperty(value = "title",required = true,index = 20)
    @Schema(description = "Name of the product", example = "Dell Laptop",required = true)
    @Size(min = 5,max = 30)
    private String productTitle;

    @Column(name = "price", nullable = false)
    @JsonProperty(value = "price",required = true,index = 30)
    @Schema(description = "price of product", example = "16000.50",required = true)
    private float price;

    @Column(name = "seller", nullable = false)
    @JsonProperty(value = "seller",required = true,index = 40)
    @Schema(description = "seller of product", example = "1",required = true)
    private String seller;

}
