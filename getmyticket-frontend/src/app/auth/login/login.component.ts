import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {HttpClient} from '@angular/common/http';

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

  apiLoginObj: any= {
    "email": "",
    "password": ""
  };

  constructor(private router: Router, private authService: AuthService) {}

  // email: string = '';
  // password: string = '';
  isLoading: boolean = false;
  http = inject(HttpClient);

  login() {
    this.http.post("http://localhost:8080/auth/login", this.apiLoginObj).subscribe((rea:any) => {
      this.isLoading = true;

      //simulation de l'appel d'api
      setTimeout(() => {
        this.isLoading = false;
        this.authService.login();//simule la connexion
        console.log("Connexion reussie !");
        this.router.navigateByUrl('/home');//Redirection vers la page d'accueil
      }, 1500);
    },error=>{
      alert("Email ou mot de passe incorrect")
    })
    //Simulation d'une connexion
    // if(this.apiLoginObj.email === 'test@example.com' && this.apiLoginObj.password === '123456'){
    //   this.isLoading = true;
    //
    //   //simulation de l'appel d'api
    //   setTimeout(() => {
    //     this.isLoading = false;
    //     this.authService.login();//simule la connexion
    //     console.log("Connexion reussie !");
    //     this.router.navigateByUrl('/home');//Redirection vers la page d'accueil
    //   }, 1500);
    //
    // }
    // else {
    //   alert("Email ou mot de passe incorrect");
    // }
    // Plus tard, appel au service d'authentification ici
  }


}
