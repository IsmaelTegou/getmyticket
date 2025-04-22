import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { RippleModule } from 'primeng/ripple';
import { AppFloatingConfigurator } from '../../layout/component/app.floatingconfigurator';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

@Component({
    selector: 'app-login',
    standalone: true,
    providers: [MessageService],
    imports: [ButtonModule,ToastModule, CheckboxModule, InputTextModule, PasswordModule, FormsModule, RouterModule, RippleModule, AppFloatingConfigurator],
    template: `
        <app-floating-configurator />
        <p-toast key="message-alert"  [showTransformOptions]="'translateY(100%)'" [showTransitionOptions]="'1000ms'" [hideTransitionOptions]="'1000ms'" [showTransformOptions]="'translateX(100%)'" />
        <div class="bg-surface-50 dark:bg-surface-950 flex items-center justify-center min-h-screen min-w-[100vw] overflow-hidden">
            <div class="flex flex-col items-center justify-center">
                <div style="border-radius: 56px; padding: 0.3rem; background: linear-gradient(180deg, var(--primary-color) 10%, rgba(33, 150, 243, 0) 30%)">
                    <div class="w-full bg-surface-0 dark:bg-surface-900 py-20 px-8 sm:px-20" style="border-radius: 53px">
                        <div class="text-center mb-8">
                          
                            <svg version="1.0" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 64 64" enable-background="new 0 0 64 64" class="mb-8 w-16 shrink-0 mx-auto" xml:space="preserve">
<g>
	<path fill="none" stroke="var(--primary-color)"stroke-width="2" stroke-miterlimit="10" d="M57,18c-1.504,1.504-2.705,2-5,2
		c-4.59,0-8-3.41-8-8c0-2.295,0.496-3.496,2-5l-6-6L1,40l6,6c1.504-1.504,2.705-2,5-2c4.59,0,8,3.41,8,8c0,2.295-0.496,3.496-2,5
		l6,6l39-39L57,18z"/>
	<line fill="none" stroke="var(--primary-color)" stroke-width="2" stroke-miterlimit="10" x1="26" y1="15" x2="30" y2="19"/>
	<line fill="none" stroke="var(--primary-color)" stroke-width="2" stroke-miterlimit="10" x1="45" y1="34" x2="49" y2="38"/>
</g>
<line fill="none" stroke="var(--primary-color)" stroke-width="2" stroke-miterlimit="10" x1="32" y1="21" x2="36" y2="25"/>
<line fill="none" stroke="var(--primary-color)" stroke-width="2" stroke-miterlimit="10" x1="39" y1="28" x2="43" y2="32"/>
</svg>
                            <div class="text-surface-900 dark:text-surface-0 text-3xl font-medium mb-4">Bienvenue sur GetMyTicket</div>
                            <span class="text-muted-color font-medium">Se connecter pour continuer</span>
                        </div>

                        <div>
                            <label for="email1" class="block text-surface-900 dark:text-surface-0 text-xl font-medium mb-2">Email</label>
                            <input pInputText id="email1" type="text" placeholder="Email address" class="w-full md:w-[30rem] mb-8" [(ngModel)]="email" />

                            <label for="password1" class="block text-surface-900 dark:text-surface-0 font-medium text-xl mb-2">Password</label>
                            <p-password id="password1" [(ngModel)]="password" placeholder="Password" [toggleMask]="true" styleClass="mb-4" [fluid]="true" [feedback]="false"></p-password>

                            <div class="flex items-center justify-between mt-2 mb-8 gap-8">
                                <div class="flex items-center">
                                    <p-checkbox [(ngModel)]="checked" id="rememberme1" binary class="mr-2"></p-checkbox>
                                    <label for="rememberme1">Se souvenir de moi</label>
                                </div>
                                <span class="font-medium no-underline ml-2 text-right cursor-pointer text-primary">
                               
                                Mot de passe oublié ?
                                
                            </span>
                            </div>
                            @if (this.isLoading) {
                                  <div class=" text-center text-primary"> <i class="pi pi-spin pi-spinner"></i></div>
                                } @else {
                            <p-button label="Se connecter" (onClick)="loginClick()" styleClass="w-full"></p-button>
                        }</div>
                    </div>
                </div>
            </div>
        </div>
    `
})

export class Login {
    email: string = '';

    password: string = '';

    checked: boolean = false;
    router = inject(Router)

    isLoading = false;
    constructor(private messageService: MessageService) {}

    loginClick() {
        console.log('Email:', this.email);
        console.log('Password:', this.password)
        //Simulation d'une connexion
        if (this.email === 'test@example.com' && this.password === '123456') {
            this.isLoading = true;

            //simulation de l'appel d'api
            setTimeout(() => {
                this.isLoading = false
                //this.authService.login();//simule la connexion
              
                this.messageService.add({
                    key: 'message-alert',
                    severity: 'success',
                    summary: 'Success',
                    detail: 'Vous êtes connecté(e)',
                });
                this.router.navigateByUrl('/');//Redirection vers la page d'accueil
            }, 2000);

        }
        else {
            
            this.messageService.add({
                key: 'message-alert',
                severity: 'error',
                summary: 'Erreur',
                detail: 'Email ou mot de passe incorrect',
            });
        }
        // Plus tard, appel au service d'authentification ici
    }
}
