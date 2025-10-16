import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms'
import { Carro } from '../../../models/carro';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-carros-details',
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './carros-details.html',
  styleUrl: './carros-details.scss'
})
export class CarrosDetails {

  carro: Carro = new Carro(0, "");
  router = inject(ActivatedRoute);
  router2 = inject(Router);

  constructor() {
    let id = this.router.snapshot.params['id'];

    if (id > 0) {
      this.findById(id)
    }
  }

  findById(id: number) {
    let carroRetornado: Carro = new Carro(2, 'Bugre')
    this.carro = carroRetornado;
  }

  save() {
    if (this.carro.id > 0) {
      Swal.fire({
        title: 'Sucesso!',
        text: 'Carro editado com sucesso!',
        icon: 'success',
        confirmButtonText: 'Ok'
      })
      this.router2.navigate(['/admin/carros',], { state: { carroEditado: this.carro } })

    } else {
      Swal.fire({
        title: 'Sucesso!',
        text: 'Carro salvo com sucesso!',
        icon: 'success',
        confirmButtonText: 'Ok'
      })
      this.router2.navigate(['/admin/carros'], { state: { carroNovo: this.carro } })
    }

  }
}
