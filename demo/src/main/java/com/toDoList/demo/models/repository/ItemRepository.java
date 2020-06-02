package com.toDoList.demo.models.repository;

import com.toDoList.demo.models.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    //Criando buscador por materia
    Optional<List<Item>> findByMateria(String materia);

//    void delete(int id);
}
