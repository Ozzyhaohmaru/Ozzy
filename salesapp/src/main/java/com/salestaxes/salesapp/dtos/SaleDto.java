package com.salestaxes.salesapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDto {
    List<ProductDto> products;
    //A anotação JsonInclude.Include.NON_NULL instrui que o atributo só exista caso seu valor seja diferente de nulo
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal salesTaxes;
    //A anotação JsonInclude.Include.NON_NULL instrui que o atributo só exista caso seu valor seja diferente de nulo
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal total;

}
