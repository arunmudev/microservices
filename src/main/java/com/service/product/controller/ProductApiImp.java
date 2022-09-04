package com.service.product.controller;


import com.service.product.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Tag(name = "Product",description = "ProductApiImp provide Documentation for Api calls")
@RequestMapping("/api/v1/products")
public interface ProductApiImp {

    @Operation(summary = "Find by product Id",description = "Returns single product",tags = {"product"})
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200",description = "Successful operation",content = @Content(schema = @Schema(implementation = Product.class))),
    @ApiResponse(responseCode = "400",description = "Invalid Id supplied",content = @Content),
    @ApiResponse(responseCode = "404",description = "Product not found",content = @Content)})
    @RequestMapping(value = "/{id}",produces = {"application/json"},method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Product>> findById(
            @Parameter(description = "Id of product",required = true)
            @PathVariable long id,
            @NotNull @Parameter(description = "select which kind of data to fetch",required = true)
            @Valid @RequestHeader(value="productAuthorization",required = true) String productAuthorization) throws Exception;

    @Operation(summary = "Insert New product",description = "Returns single product",tags = {"product"})
    @ApiResponses(value =
            {@ApiResponse(responseCode = "201",description = "Successful operation",content = @Content(mediaType ="application/json" ,schema = @Schema(implementation = Product.class)))})
    @PostMapping(value = "/insert", consumes = {"application/json","application/xml","application/x-www-form-urlencoded"})
    @ResponseStatus(HttpStatus.CREATED)
    public Object insertProduct(
            @Parameter(description = "inserted product",required = true)
            @Valid @RequestBody Product product,
            @NotNull @Parameter(description = "select which kind of data to fetch",required = true)
            @Valid @RequestHeader(value="productAuthorization",required = true) String productAuthorization) throws Exception;
}
