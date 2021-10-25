package br.com.diolabs.lojaapi.dto;

import java.util.List;

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
public class ShopDTO {

    private Integer id;
    private String name;
    List<FruitDTO> fruits;

}
