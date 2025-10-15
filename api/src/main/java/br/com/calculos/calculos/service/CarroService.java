package br.com.calculos.calculos.service;

import br.com.calculos.calculos.entities.Carro;
import br.com.calculos.calculos.entities.Marca;
import br.com.calculos.calculos.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepo;


    public String save(Carro carro){
        this.verificarNomeCarro(carro.getNome(), carro.getAnoFabricacao());

        this.carroRepo.save(carro);
        return carro.getNome() + " salvo com sucesso";
    }

    public List<Carro> getAll(){
        return this.carroRepo.findAll();
    }

    public Carro getById(Long id){
        Optional<Carro> foundCarro = this.carroRepo.findById(id);
        return foundCarro.orElseThrow(() -> new RuntimeException("Carro não encontrado") );
    }

    public String delete (Long id){
          this.carroRepo.deleteById(id);
          return "Carro com o id "+ id + " deletado com sucesso!";
    }

    public Carro update (Long id, Carro carro){
        this.verificarNomeCarro(carro.getNome(), carro.getAnoFabricacao());

        Carro existingCarro = getById(id);
        existingCarro.setModelo(carro.getModelo());
        existingCarro.setMarca(carro.getMarca());
        existingCarro.setAnoFabricacao(carro.getAnoFabricacao());
        existingCarro.setNome(carro.getNome());

        Carro updatedCarro = this.carroRepo.save(existingCarro);
        return updatedCarro;
    }

    public List<Carro> findByNome(String nome){
        return this.carroRepo.findByNome(nome);
    }

    public List<Carro> findByMarca(Long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        return this.carroRepo.findByMarca(marca);
    }

    public List<Carro> findAcimaAno(int ano){
        return this.carroRepo.findAcimaAno(ano);
    }

    public void verificarNomeCarro(String nome, int ano){
        if(nome.equals("Jeep Compass") && ano < 2006){
            throw new RuntimeException();
        }
    }
}
