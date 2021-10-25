package br.com.diolabs.lojaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.diolabs.lojaapi.dto.FruitDTO;
import br.com.diolabs.lojaapi.model.Fruit;

/**
 * Classe permite fazer o mapeamento entre o objeto de transferência de dados {@link FruitDTO} e entidade que o representa no banco {@link Fruit}
 * usando o framework MapStruct.
 * <li>Demonstraçã do padrão de projeto DTO Pattern</li>
 * <li>Demonstra o uso do padrão de design Strategy</li>
 * 
 * 
 * @see <a href="https://mapstruct.org/">MapStruct Framework </a>
 
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FruitMapper {
   
    Fruit toModel(FruitDTO fruitDTO);
   
    FruitDTO toDTO(Fruit fruit);
}
