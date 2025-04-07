import { Routes } from '@angular/router';
import {LoginComponent} from './auth/login/login.component';
import {HomeComponent} from './pages/home/home.component';
import {authGuard} from './guards/auth.guard';
import {RegisterComponent} from './auth/register/register.component';
import {MainLayoutComponent} from './components/main-layout/main-layout.component';

// export const routes: Routes = [
//   {
//     path:'',
//     redirectTo: 'login',
//     pathMatch: 'full'
//   },
//   {
//     path: 'login',
//     component: LoginComponent
//   },
//   {
//     path:'',
//     component: LayoutComponent,
//   },
//   {
//     path:'',
//     component:LayoutComponent,
//     children:[
//       {
//         path:'home',
//         component: HomeComponent
//       }
//     ]
//   }
// ];

export const routes: Routes = [
  {
    path:'',
    redirectTo:'login',
    pathMatch:'full',
  },
  {
    path:'login',
    component: LoginComponent,
  },
  {
    path:'register',
    component: RegisterComponent
  },
  {
    path:'',
    component: MainLayoutComponent,
    canActivateChild: [authGuard],
    children:[
      {
        path:'home',
        component: HomeComponent,
      }
    ]
  },
];
