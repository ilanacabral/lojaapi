package br.com.diolabs.lojaapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diolabs.lojaapi.dto.FruitDTO;
import br.com.diolabs.lojaapi.exception.NotFoundException;
import br.com.diolabs.lojaapi.mapper.FruitMapper;
import br.com.diolabs.lojaapi.model.Fruit;
import br.com.diolabs.lojaapi.repository.FruitRepository;
import br.com.diolabs.lojaapi.service.FruitAPIService;
import br.com.diolabs.lojaapi.service.ServiceStrategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe de implementação do serviço para a entidade Fruit
 * 
 * <li>Demonstração do padrão de projeto Strategy - implementa interface
 * {@link ServiceStrategy}</li>
 * 
 * <li>Demonstração do pardão de projeto Facade - trata integração com
 * subsistemas externos {@link FruitAPIService}</li>
 * 
 * <li>Demonstração do padrão de projeto Singleton - a classe é um
 * {@link Service}, pode ser injetado pelo Spring com {@link Autowired}</li>
 * 
 * <li>Demonstração do padrão de projeto DTO Pattern - usamos o componente
 * {@link FruitMapper} para transferir os dados entre processos sem que ambos
 * DTO e model não precisem se conhecer.</li>
 * 
 * 
 */
@Service
public class FruitServiceImpl implements ServiceStrategy<FruitDTO, Integer> {

    private static final Logger logger = LogManager.getLogger(FruitServiceImpl.class);

    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    FruitMapper fruitMapper;

    @Autowired
    FruitAPIService fruitAPIService;

    public List<Fruit> getFruits(List<FruitDTO> fruits) {

        List<Fruit> lista = new ArrayList<>();
        for (FruitDTO f : fruits) {
            Optional<Fruit> opt = fruitRepository.findByName(f.getName());
            if (opt.isPresent()) {
                lista.add(opt.get());
            } else {
                try {
                    Fruit fr = fruitAPIService.getFruit(f.getName());
                    lista.add(fr);
                } catch (Exception e) {
                    logger.error("The fruit " + f.getName() + " was not found! -> " + e.getMessage(),e);
                }
            }
        }
        return lista;      

    }

    @Override
    public Set<FruitDTO> findAll() {
        return fruitRepository.findAll().stream().map(fruitMapper::toDTO).collect(Collectors.toSet());
    }

    @Override
    public FruitDTO findById(Integer id) {
        Optional<Fruit> optFruit = fruitRepository.findById(id);
        return fruitMapper
                .toDTO(optFruit.orElseThrow(() -> new NotFoundException("Fruit with ID: " + id + "not found!")));
    }

    @Override
    public FruitDTO save(FruitDTO entity) {
        /** Feito por cascateamento */
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        /** Feito por cascateamento */
    }

    /** Feito por cascateamento */
    @Override
    public FruitDTO update(Integer id, FruitDTO entity) {
        /** Feito por cascateamento */
        return null;
    }

}
