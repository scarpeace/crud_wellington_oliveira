import { Routes } from '@angular/router';
import { Login } from './components/layout/login/login';
import { Principal } from './components/layout/principal/principal';
import { CarrosList } from './components/carros/carros-list/carros-list';
import { CarrosDetails } from './components/carros/carros-details/carros-details';
import { MarcasDetails } from './components/marcas/marcas-details/marcas-details';
import { MarcasList } from './components/marcas/marcas-list/marcas-list';

export const routes: Routes = [
    { path: "", redirectTo: "login", pathMatch: "full" },
    { path: "login", component: Login },
    {
        path: "admin", component: Principal, children: [
            { path: "carros", component: CarrosList },
            { path: "carros/new", component: CarrosDetails },
            { path: "carros/edit/:id", component: CarrosDetails },
            { path: "marcas", component: MarcasList },
            { path: "marcas/new", component: MarcasDetails },
            { path: "marcas/edit/:id", component: MarcasDetails },
        ]
    }

];
