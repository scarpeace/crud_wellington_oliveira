import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carros-list',
  imports: [RouterLink],
  templateUrl: './carros-list.html',
  styleUrl: './carros-list.scss'
})
export class CarrosList {

  lista: Carro[] = []

  constructor() {

    let novoCarro = history.state.carroNovo;
    let carroEditado = history.state.carroEditado;


    this.lista.push(new Carro(1, 'Ford Ka'));
    this.lista.push(new Carro(2, 'Fiat Uno'));
    this.lista.push(new Carro(3, 'Fiat Siena'));
    this.lista.push(new Carro(4, 'Toyota Hilux'));

    if (carroEditado) {
      let indice = this.lista.findIndex(c => (c.id === carroEditado.id));
      this.lista[indice] = carroEditado;
    }

    if (novoCarro) {
      novoCarro.id = 4;
      this.lista.push(novoCarro)
    }

  }

  editar() {
    console.log("editar Carro")
  }

  deleteById(carro: Carro) {

    Swal.fire({
      title: 'Sucesso!',
      text: 'Tem certeza que deseja deletar o registro?',
      showConfirmButton: true,
      showCancelButton: true,
      confirmButtonText: 'Sim',
      cancelButtonText: "Cancelar"

    }).then((result) => {
      if (result.isConfirmed) {
        let indice = this.lista.findIndex(c => (c.id === carro.id));
        this.lista.splice(indice, 1);

        Swal.fire({
          title: 'Sucesso!',
          text: 'Carro deletado com sucesso!',
          icon: 'success',
          confirmButtonText: 'Ok'
        })
      }
    })
  }
}
