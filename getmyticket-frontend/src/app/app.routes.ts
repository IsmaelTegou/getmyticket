import { Routes } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {LayoutComponent} from './components/layout/layout.component';
import {HomeComponent} from './components/layout/home/home.component';

export const routes: Routes = [
  {
    path:'',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path:'',
    component: LayoutComponent,
  },
  {
    path:'',
    component:LayoutComponent,
    children:[
      {
        path:'home',
        component: HomeComponent
      }
    ]
  }
];
