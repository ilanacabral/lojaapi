package br.com.diolabs.lojaapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diolabs.lojaapi.dto.ShopDTO;
import br.com.diolabs.lojaapi.exception.NotFoundException;
import br.com.diolabs.lojaapi.mapper.ShopMapper;
import br.com.diolabs.lojaapi.model.Fruit;
import br.com.diolabs.lojaapi.model.Shop;
import br.com.diolabs.lojaapi.repository.ShopRepository;
import br.com.diolabs.lojaapi.service.ServiceStrategy;

/**
 * Classe de implementação do serviço para a entidade Shop
 * 
 * <li>Demonstração do padrão de projeto Strategy - implementa interface
 * {@link ServiceStrategy}</li>
 * 
 * <li>Demonstração do pardão de projeto Facade - trata integração com
 * {@link FruitServiceImpl}</li>
 * 
 * <li>Demonstração do padrão de projeto Singleton - a classe é um
 * {@link Service}, pode ser injetado pelo Spring com {@link Autowired}</li>
 * 
 * <li>Demonstração do padrão de projeto DTO Pattern - usamos o componente
 * {@link ShopMapper} para transferir os dados entre processos sem que ambos DTO
 * e model não precisem se conhecer.</li>
 * 
 * 
 */
@Service
public class ShopServiceImpl implements ServiceStrategy<ShopDTO, Integer> {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    FruitServiceImpl fruitService;

    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<ShopDTO> findAll() {
        return shopRepository.findAll().stream().map(shopMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ShopDTO findById(Integer id) {
        Optional<Shop> optShop = shopRepository.findById(id);
        return shopMapper.toDTO(optShop.orElseThrow(() -> new NotFoundException("Shop with ID: " + id + "not found!")));

    }

 
    @Override    
    public ShopDTO save(ShopDTO shopToSave) {
        Shop shop = shopMapper.toModel(shopToSave);

        List<Fruit> fruits = fruitService.getFruits(shopToSave.getFruits());
        shop.setFruits(fruits);

        shop = shopRepository.save(shop);

        return shopMapper.toDTO(shop);
    }

    @Override
    public void deleteById(Integer id) {
        ShopDTO shopToDelete = this.findById(id);

        //Remove relacionamentos filhos
        shopToDelete.setFruits(null);
        shopRepository.delete(shopMapper.toModel(shopToDelete));
    }

    @Override
    public ShopDTO update(Integer id, ShopDTO shopToUpdate) {
        this.findById(id);
        Shop shop = shopMapper.toModel(shopToUpdate);
        
        List<Fruit> fruits = fruitService.getFruits(shopToUpdate.getFruits());
        shop.setFruits(fruits);

        shop = shopRepository.save(shop);
        return shopMapper.toDTO(shop);
    }

}
