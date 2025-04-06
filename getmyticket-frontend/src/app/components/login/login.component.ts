import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginObj: any = {
    email: '',
    password: ''
  };

  router = inject(Router);

  onLogin() {
    if (this.loginObj.email === 'admin@gmail.com' && this.loginObj.password === 'admin') {
      this.router.navigateByUrl("home");
    }
    else {
      alert("Wrong credentials. Please try again later.");
    }
  }
}
