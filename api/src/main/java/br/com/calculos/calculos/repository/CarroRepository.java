package br.com.calculos.calculos.repository;

import br.com.calculos.calculos.entities.Carro;
import br.com.calculos.calculos.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByNome(String nome);
    public List<Carro> findByMarca(Marca marca);

    @Query("SELECT c FROM Carro c where c.anoFabricacao > :ano")
    public List<Carro> findAcimaAno(int ano);
}
