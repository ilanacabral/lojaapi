package br.com.diolabs.lojaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.diolabs.lojaapi.dto.ShopDTO;
import br.com.diolabs.lojaapi.model.Shop;


/**
 * Classe permite fazer o mapeamento entre o objeto de transferência de dados {@link ShopDTO} e entidade que o representa no banco {@link Shop}
 * usando o framework MapStruct.
 * <li>Demonstraçã do padrão de projeto DTO Pattern</li>
 * <li>Demonstra o uso do padrão de design Strategy</li>
 * 
 * 
 * @see <a href="https://mapstruct.org/">MapStruct Framework </a>
 
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper {

    Shop toModel(ShopDTO fruitDTO);   
    
    ShopDTO toDTO(Shop fruit);
    
}
