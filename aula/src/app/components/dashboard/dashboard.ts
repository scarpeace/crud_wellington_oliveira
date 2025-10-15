import { Component } from '@angular/core';
import { CarrosList } from "../carros-list/carros-list";

@Component({
  selector: 'app-dashboard',
  imports: [CarrosList],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss'
})
export class Dashboard {

}
