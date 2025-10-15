import { Component } from '@angular/core';
import { Carro } from '../../models/carro';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carros-list',
  imports: [CommonModule],
  templateUrl: './carros-list.html',
  styleUrl: './carros-list.scss'
})
export class CarrosList {
  lista: Carro[] = [];

  constructor() {
    let carro: Carro = new Carro();
    carro.id = 1;
    carro.marca = "Ford";
    carro.nome = "Ford Fiesta"

    let carro1: Carro = new Carro();
    carro1.id = 2;
    carro1.marca = "Chevrolet";
    carro1.nome = "Monza"

    let carro2: Carro = new Carro();
    carro2.id = 3;
    carro2.marca = "Fiat";
    carro2.nome = "Uno"

    this.lista.push(carro);
    this.lista.push(carro1);
    this.lista.push(carro2);

    console.log(this.lista)
  }

}
