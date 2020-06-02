package com.toDoList.demo.controllers;

import com.toDoList.demo.models.entities.Item;
import com.toDoList.demo.models.repository.ItemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API REST To Do List")
@CrossOrigin(origins = "*") //Liberando acesso para todos os dominios acessarem
public class ItemController {

    @Autowired // Com essa anotação indicamos que os parâmetros do nosso construtor serão injetados
    private ItemRepository itemRepository;

    //Inserindo Novo Item
    @PostMapping(path = "/Item")
    @ApiOperation(value = "Inserir nova tarefa")
    public String newItem (Item item){
        itemRepository.save(item);
        return "Novo Item inserido";
    }
    //Deletando Item
    @DeleteMapping(path = "/Item/{id}")
    @ApiOperation(value = "Deletando uma tarefa por Id num parâmetro")
    public String deletandoITem(@PathVariable int id){
        itemRepository.deleteById(id);
        return "Deletado com Sucesso.";
    }
    //Retornando Todos os Items
    @GetMapping(path = "/Item")
    @ApiOperation(value = "Retornando todas as tarefas")
    public Iterable<Item> get(){
        return itemRepository.findAll();
    }
    //Buscando por Materia
    @GetMapping(path = "/ItemByMat/{mat}")
    public Optional<List<Item>> searchByMateria(@PathVariable String mat){
        Optional<List<Item>> item =itemRepository.findByMateria(mat);
        return item;
    }
    //Editando Item
    @PutMapping(path = "/Item")
    @ApiOperation(value = "Editando um determinado item ")
    public Item EditandoItem(@RequestBody Item item){ // Recebendo o Json modificado no front
        return itemRepository.save(item);
    }
}
