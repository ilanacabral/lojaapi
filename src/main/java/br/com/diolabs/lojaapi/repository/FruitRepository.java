package br.com.diolabs.lojaapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diolabs.lojaapi.model.Fruit;
/**
 * Classe responsável pela persistência do objeto Fruit
 * <li>Demonstração do padrão de projeto Strategy</li>
 */
@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer>{
    
    @Query("SELECT f FROM Fruit f WHERE lower(f.name) LIKE lower(:name)")
    Optional<Fruit> findByName(String name);
}
