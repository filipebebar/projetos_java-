package br.com.filipe.teste.filipe_teste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @Column
    private Boolean done;

    @Column
    @JsonFormat(pattern = "dd/mm/yyyy HH:MM")
    private LocalDateTime createDate;

    @Column
    @JsonFormat(pattern = "dd/mm/yyyy HH:MM")
    private LocalDateTime doneDate;

    @PrePersist
    public void beforeSave() {
        setCreateDate(LocalDateTime.now());
    }
}
