package br.com.diolabs.lojaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.lojaapi.dto.ShopDTO;
import br.com.diolabs.lojaapi.service.impl.ShopServiceImpl;

/**
 * Representa uma fachada simples para uso das funcionalidades, abstraindo a complexidade de integração entre processos e subsistemas
 */
@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

    //Padrão de projeto Singleton
    @Autowired ShopServiceImpl shopServiceImpl;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShopDTO> findAllShop(){
        return shopServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ShopDTO findShopById(@Valid @PathVariable Integer id){
        return shopServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO saveShop(@Valid @RequestBody ShopDTO shopToSave){
        return shopServiceImpl.save(shopToSave);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopDTO updateShop(@Valid @PathVariable Integer id, @Valid @RequestBody ShopDTO shopToUpdate){
        return shopServiceImpl.update(id, shopToUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@Valid @PathVariable Integer id){
        shopServiceImpl.deleteById(id);
    }
    
}
