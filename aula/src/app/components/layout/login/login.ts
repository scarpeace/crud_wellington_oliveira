import { Component, inject } from '@angular/core';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms'
import { FormsModule } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {

  usuario!: string;
  senha!: string;

  //Equivalente ao @AutoWired do spring
  router = inject(Router);

  logar() {
    if (this.usuario == 'admin' && this.senha == 'admin') {
      this.router.navigate(['admin/carros'])
    } else {
      alert("Usuário e senha estão incorretos")
    }
  }

}
