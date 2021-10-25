package br.com.diolabs.lojaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diolabs.lojaapi.model.Shop;

/**
 * Classe responsável pela persistência do objeto Shop
 * <li>Demonstração do padrão de projeto Strategy</li>
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer>{
    
}
