import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {LayoutComponent} from './components/layout/layout.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginComponent, LayoutComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'getmyticket-frontend';
}
