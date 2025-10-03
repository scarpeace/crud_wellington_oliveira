package br.com.calculos.calculos.controller;

import br.com.calculos.calculos.entities.Carro;
import br.com.calculos.calculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try{
            String mensagem = this.carroService.save(carro);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Carro>> getAll(){
        try{
            List<Carro> carros = this.carroService.getAll();
            return new ResponseEntity<>(carros, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        try{
            Carro carro = this.carroService.getById(id);
            return new ResponseEntity<Carro>(carro, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String mensagem = this.carroService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro carro){
        try {
            Carro updatedCarro = this.carroService.update(id, carro);
            return new ResponseEntity<Carro>(updatedCarro, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
        try{
            List<Carro> lista = this.carroService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam Long marcaId){
        try{
            List<Carro> lista = this.carroService.findByMarca(marcaId);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcima(@RequestParam int ano){
        try{
            List<Carro> lista = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
