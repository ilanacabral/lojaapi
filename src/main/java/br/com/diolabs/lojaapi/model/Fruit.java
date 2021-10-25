package br.com.diolabs.lojaapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula objeto Fruit
 */


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {

    @Id    
    private Integer id; 
   
    @Column(nullable = false,unique = true)
    private String name;
   
    @Column(nullable = false)
    private String genus;
   
    @Column(nullable = false)
    private String family;
   
    @Column(name = "orderfruit",nullable = false)
    private String order;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})   
    private Nutritions nutritions;   

    @ManyToMany(mappedBy = "fruits")
    private List<Shop> shops;

}
