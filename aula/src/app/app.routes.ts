import { Routes } from '@angular/router';
import { CarrosList } from './components/carros-list/carros-list';
import { Dashboard } from './components/dashboard/dashboard';

export const routes: Routes = [
    { path: "", redirectTo: "dashboard", pathMatch: 'full' },
    { path: "dashboard", component: Dashboard },
    { path: "carros", component: CarrosList }
];
