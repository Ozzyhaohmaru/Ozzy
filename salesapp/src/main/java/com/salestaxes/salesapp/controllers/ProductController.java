package com.salestaxes.salesapp.controllers;

import com.salestaxes.salesapp.dtos.SaleDto;
import com.salestaxes.salesapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public @ResponseBody List<SaleDto> executeProductOperation(@RequestBody List<SaleDto> sales) {
        return this.productService.executeProductOperation(sales);
    }
}

