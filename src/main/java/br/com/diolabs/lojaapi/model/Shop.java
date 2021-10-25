package br.com.diolabs.lojaapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Classe que encapsula o objeto Shop
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Fruit> fruits;

    
}
