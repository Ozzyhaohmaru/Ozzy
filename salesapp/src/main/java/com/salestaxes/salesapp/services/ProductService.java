package com.salestaxes.salesapp.services;

import com.salestaxes.salesapp.dtos.ProductDto;
import com.salestaxes.salesapp.dtos.SaleDto;
import com.salestaxes.salesapp.enums.ECategory;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class ProductService {
    private static final BigDecimal BASIC_SALES_TAXES = BigDecimal.valueOf(0.10);
    private static final BigDecimal IMPORT_SALES_TAXES = BigDecimal.valueOf(0.05);

    public List<SaleDto> executeProductOperation(List<SaleDto> sales) {
        if(sales.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty sales");
        }else{
            for(SaleDto sale : sales){
                sale.setSalesTaxes(BigDecimal.ZERO);
                sale.setTotal(BigDecimal.ZERO);
                BigDecimal totalValueOfSaleTax = BigDecimal.ZERO;
                if(sale.getProducts().isEmpty()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty products list");
                }else{
                    for(ProductDto product : sale.getProducts()){
                        BigDecimal productTaxes = BigDecimal.ZERO;
                        if(product.getIsImport()){
                            productTaxes = productTaxes.add(product.getValue().multiply(IMPORT_SALES_TAXES));
                        }
                        if(!Objects.isNull(product.getCategory()) && !Arrays.asList(
                                ECategory.BOOKS.getId(),
                                ECategory.FOODS.getId(),
                                ECategory.MPS.getId()).contains(product.getCategory())){
                            productTaxes = productTaxes.add(product.getValue().multiply(BASIC_SALES_TAXES));
                                    product.getValue().multiply(BASIC_SALES_TAXES);
                        }else if(Objects.isNull(product.getCategory())){
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category must be provided");
                        }
                        totalValueOfSaleTax = totalValueOfSaleTax.add(productTaxes).setScale(2, RoundingMode.HALF_UP);
                        product.setValue((product.getValue().add(productTaxes)).setScale(2, RoundingMode.FLOOR));
                    }
                }
                sale.setSalesTaxes(totalValueOfSaleTax);
                sale.setTotal(sale.getProducts().stream().map(ProductDto::getValue).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
            }
        }
        return sales;
    }
}
