package br.com.calculos.calculos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do carro não pode ser nulo")
    private String nome;

    @NotNull(message = "O modelo do carro não pode ser nulo")
    private String modelo;

    @NotNull(message = "O ano de fabricação do carro não pode ser nulo")
    private int anoFabricacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carro")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="carro_proprietario")
    private List<Proprietario> proprietarios;


}
