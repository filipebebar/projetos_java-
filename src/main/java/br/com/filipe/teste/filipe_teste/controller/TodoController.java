package br.com.filipe.teste.filipe_teste.controller;

import br.com.filipe.teste.filipe_teste.model.Todo;
import br.com.filipe.teste.filipe_teste.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api-todo")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @PostMapping("/")
    public Todo save(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @GetMapping("/{idTodo}")
    public Todo getById(@PathVariable(name = "idTodo") Long idTodo) {
        return repository.findById(idTodo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public List<Todo> listar() {
        return repository.findAll();
    }
}
