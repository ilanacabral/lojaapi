package br.com.diolabs.lojaapi.service;

/**
 * Interface que contém os comportamentos que devem ser implementados
 * Demonstração do padrão de projeto Strategy
 */
public interface ServiceStrategy<T,ID> {
   
    public abstract java.lang.Iterable<T> findAll();

    public abstract T findById(ID id);

    public abstract T save(T entity);

    public abstract  void deleteById(ID id);

    public abstract T update(ID id, T entity);

}
