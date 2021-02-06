package br.com.filipe.teste.filipe_teste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 120)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Column
    @JsonFormat(pattern = "dd/mm/yyyy HH:MM")
    private LocalDateTime createDate;

    @PrePersist
    public void beforeSave() {
        setCreateDate(LocalDateTime.now());
    }

}
