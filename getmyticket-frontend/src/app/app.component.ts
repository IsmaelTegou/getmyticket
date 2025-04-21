import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {LoginComponent} from './auth/login/login.component';
import {HomeComponent} from './pages/home/home.component';
import {FooterComponent} from './components/footer/footer.component';
import {Button} from 'primeng/button';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FooterComponent, Button],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'getmyticket-frontend';
}
