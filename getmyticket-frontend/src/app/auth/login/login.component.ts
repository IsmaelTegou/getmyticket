import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  // loginObj: any = {
  //   email: '',
  //   password: ''
  // };
  //
  // router = inject(Router);
  //
  // onLogin() {
  //   if (this.loginObj.email === 'admin@gmail.com' && this.loginObj.password === 'admin') {
  //     this.router.navigateByUrl("home");
  //   }
  //   else {
  //     alert("Wrong credentials. Please try again later.");
  //   }
  // }

  constructor(private router: Router, private authService: AuthService) {}

  email: string = '';
  password: string = '';
  isLoading: boolean = false;

  login() {
    console.log('Email:', this.email);
    console.log('Password:', this.password)
    //Simulation d'une connexion
    if(this.email === 'test@example.com' && this.password === '123456'){
      this.isLoading = true;

      //simulation de l'appel d'api
      setTimeout(() => {
        this.isLoading = false;
        this.authService.login();//simule la connexion
        console.log("Connexion reussie !");
        this.router.navigateByUrl('/home');//Redirection vers la page d'accueil
      }, 1500);

    }
    else {
      alert("Email ou mot de passe incorrect");
    }
    // Plus tard, appel au service d'authentification ici
  }


}
