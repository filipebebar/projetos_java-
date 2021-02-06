package br.com.filipe.teste.filipe_teste.repository;

import br.com.filipe.teste.filipe_teste.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
