import {Component, inject} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormBuilder, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {AuthService} from '../../services/auth.service';
import {Client} from '../../models/client';
import {ClientService} from '../../services/client.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  numCNI = '';
  firstName = '';
  lastName = '';
  phone = '';
  email = '';
  password = '';
  isLoading = false;

  constructor(private router: Router, private authService: AuthService, private clientService: ClientService) {}

  register() {
    if (
      !this.numCNI ||
      !this.firstName ||
      !this.lastName ||
      !this.phone ||
      !this.email ||
      !this.password
    ) {
      // Simule la création du compte
    //   this.isLoading = true;
    //   setTimeout(() => {
    //     this.authService.login(); // L'utilisateur est maintenant "connecté"
    //     this.router.navigateByUrl('/home');
    //     this.isLoading = false;
    //   }, 1500)
    // } else {
    //   alert("Veuillez remplir tous les champs.");
    // }

      return;
  }

    this.isLoading = true;

    const newClient: Client = {
      numCNI: this.numCNI,
      firstName: this.firstName,
      lastName: this.lastName,
      phone: this.phone,
      email: this.email,
      password: this.password
    };

    this.clientService.registerClient(newClient).subscribe({
      next: (response: Client) => {
        console.log('Client inscrit avec succès :', response);
        alert('Inscription réussie !');
        this.resetForm();
        this.isLoading = false;
      },
      error: () => {
        //console.error('Erreur lors de l’inscription :', err);
        alert('Une erreur est survenue lors de l’inscription.');
        this.isLoading = false;
      }
    });
  }

  private resetForm(): void {
    this.numCNI = '';
    this.firstName = '';
    this.lastName = '';
    this.phone = '';
    this.email = '';
    this.password = '';
  }

}
