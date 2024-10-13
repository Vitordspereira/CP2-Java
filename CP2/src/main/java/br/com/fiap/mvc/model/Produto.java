package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CAD_PRODUTO")
@Getter
@Setter

public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nm_produto", length = 100)
    private String nome;

    @Column(name = "ds_descricao", length = 100)
    private String descricao;

    @Column(name = "vl_preco", scale = 2)
    private Double preco;

    @Column(name = "dt_fabricacao")
    private LocalDate dataFabricacao;

}

