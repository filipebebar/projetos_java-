package br.com.filipe.teste.filipe_teste.repository;


import br.com.filipe.teste.filipe_teste.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
