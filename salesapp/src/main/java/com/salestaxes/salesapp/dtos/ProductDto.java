package com.salestaxes.salesapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    //O atributo é do tipo Long pq para a quantidade não é necessário casas decimais.
    private Long qty;
    //O atributo é String pq se trata de texto
    private String descryption;
    //O atributo é BigDecimal para utilizarmos casas decimais.
    private BigDecimal value;
    //O  atributo category será utilziado em um enum para identificar o tipo de cada produto.
    private Long category;
    //O atributo is import será utilizado para classificar se um produto é importado ou não.
    private Boolean isImport;

}
