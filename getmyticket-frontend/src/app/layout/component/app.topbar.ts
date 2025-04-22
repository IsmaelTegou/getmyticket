import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { StyleClassModule } from 'primeng/styleclass';
import { AppConfigurator } from './app.configurator';
import { LayoutService } from '../service/layout.service';

@Component({
    selector: 'app-topbar',
    standalone: true,
    imports: [RouterModule, CommonModule, StyleClassModule, AppConfigurator],
    template: ` <div class="layout-topbar">
        <div class="layout-topbar-logo-container">
            <button class="layout-menu-button layout-topbar-action" (click)="layoutService.onMenuToggle()">
                <i class="pi pi-bars"></i>
            </button>
            <a class="layout-topbar-logo" routerLink="/">
               <span class=" translate-y-3 scale-[0.8] ">
               <svg version="1.0" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 64 64" enable-background="new 0 0 64 64" class="mb-8 w-16 shrink-0 mx-auto" xml:space="preserve">
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
               </span>
                <span class=" text-primary font-bold">GetMyTicket</span>
            </a>
        </div>

        <div class="layout-topbar-actions">
            <div class="layout-config-menu">
                <button type="button" class="layout-topbar-action" (click)="toggleDarkMode()">
                    <i [ngClass]="{ 'pi ': true, 'pi-moon': layoutService.isDarkTheme(), 'pi-sun': !layoutService.isDarkTheme() }"></i>
                </button>
                <div class="relative">
                    <button
                        class="layout-topbar-action layout-topbar-action-highlight"
                        pStyleClass="@next"
                        enterFromClass="hidden"
                        enterActiveClass="animate-scalein"
                        leaveToClass="hidden"
                        leaveActiveClass="animate-fadeout"
                        [hideOnOutsideClick]="true"
                    >
                        <i class="pi pi-palette"></i>
                    </button>
                    <app-configurator />
                </div>
            </div>

            <button class="layout-topbar-menu-button layout-topbar-action" pStyleClass="@next" enterFromClass="hidden" enterActiveClass="animate-scalein" leaveToClass="hidden" leaveActiveClass="animate-fadeout" [hideOnOutsideClick]="true">
                <i class="pi pi-ellipsis-v"></i>
            </button>

            <div class="layout-topbar-menu hidden lg:block">
                <div class="layout-topbar-menu-content">
                    <button type="button" class="layout-topbar-action">
                        <i class="pi pi-calendar"></i>
                        <span>Reservations</span>
                    </button>
                    <button type="button" class="layout-topbar-action">
                        <i class="pi pi-inbox"></i>
                        <span>Notification</span>
                    </button>
                    <button type="button" class="layout-topbar-action">
                        <i class="pi pi-user"></i>
                        <span>Compte</span>
                    </button>
                </div>
            </div>
        </div>
    </div>`
})
export class AppTopbar {
    items!: MenuItem[];

    constructor(public layoutService: LayoutService) {}

    toggleDarkMode() {
        this.layoutService.layoutConfig.update((state) => ({ ...state, darkTheme: !state.darkTheme }));
    }
}
