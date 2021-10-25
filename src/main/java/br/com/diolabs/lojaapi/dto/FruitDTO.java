package br.com.diolabs.lojaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe representa o objeto de transferência de dados entre o controller e o service
 * <li>Demonstraçã do padrão de projeto DTO Pattern</li>
 * <li>Demonstração do padrão de projeto {@link Builder} pra criação de novas instâncias,usando Lombok Framework</li>
 * 
 * @see <a href="https://projectlombok.org/">Lombok Framework</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitDTO {

    private String genus;
    private String name;
    private Integer id; 
    private String family;   
    private String order;
    private NutritionsDTO nutritions;   

    
}
