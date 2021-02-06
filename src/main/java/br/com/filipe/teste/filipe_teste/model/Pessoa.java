package br.com.filipe.teste.filipe_teste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cpf;

    @Column(nullable = false, length = 10)
//    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date dataNascimento;

    @JsonIgnoreProperties("pessoa")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    @Column
    @JsonFormat(pattern = "dd/mm/yyyy HH:MM")
    private LocalDateTime createDate;

    @PrePersist
    public void beforeSave() {
        setCreateDate(LocalDateTime.now());
    }
}
