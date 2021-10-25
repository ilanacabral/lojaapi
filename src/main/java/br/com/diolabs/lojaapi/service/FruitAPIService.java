package br.com.diolabs.lojaapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.diolabs.lojaapi.model.Fruit;
/**
 * Cliente HTTP, criando via OpenFeign, para consumir a API Fruityvice que retorna informações sobre frutas
 * 
 * @see <a href="https://www.fruityvice.com/#2">Fruityvice API</a>
 * 
 */

@FeignClient(name = "fruitapi", url = "https://www.fruityvice.com")
public interface FruitAPIService {

    //@RequestMapping(method = RequestMethod.GET , value = "api/fruit/{fruitname}",consumes = "application/json", produces = "application/json")
    @GetMapping(value = "api/fruit/{fruitname}", consumes = "application/json", produces = "application/json" )
    Fruit getFruit(@PathVariable("fruitname") String fruitname);
    
    
}
