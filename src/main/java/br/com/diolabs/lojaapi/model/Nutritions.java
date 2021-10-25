package br.com.diolabs.lojaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula o objeto Nutritions (informações nutricionais)
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nutritions {

    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private Integer id;
   
    @Column(nullable = false)
    private Integer carbohydrates;
   
    @Column(nullable = false)
    private Integer protein;
   
    @Column(nullable = false)
    private Double fat;
   
    @Column(nullable = false)
    private Integer calories;
    
    @Column(nullable = false)
    private Double sugar;

   // @OneToOne(mappedBy = "nutrition")
   // private Fruit fruit;


}