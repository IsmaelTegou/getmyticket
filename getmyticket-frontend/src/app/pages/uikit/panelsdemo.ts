import { CommonModule } from '@angular/common';
import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AccordionModule } from 'primeng/accordion';
import {MenuItem, MessageService} from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { DividerModule } from 'primeng/divider';
import { FieldsetModule } from 'primeng/fieldset';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { MenuModule } from 'primeng/menu';
import { PanelModule } from 'primeng/panel';
import { RippleModule } from 'primeng/ripple';
import { SplitButtonModule } from 'primeng/splitbutton';
import { SplitterModule } from 'primeng/splitter';
import { TabsModule } from 'primeng/tabs';
import { ToolbarModule } from 'primeng/toolbar';
import {TableModule} from "primeng/table";
import {Trajet} from "../../models/trajet";
import {TrajetService} from "../../services/trajet.service";
import {DropdownModule} from "primeng/dropdown";
import {Dialog} from "primeng/dialog";
import {TrajetSearch} from "../../types/trajetSearch";
import {Observable, of} from "rxjs";
import {Tooltip} from "primeng/tooltip";

@Component({
    selector: 'app-panels-demo',
    standalone: true,
    imports: [
        CommonModule,
        FormsModule,
        ToolbarModule,
        ButtonModule,
        RippleModule,
        SplitButtonModule,
        AccordionModule,
        FieldsetModule,
        MenuModule,
        InputTextModule,
        DividerModule,
        SplitterModule,
        PanelModule,
        TabsModule,
        IconFieldModule,
        InputIconModule,
        TableModule,
        ReactiveFormsModule,
        DropdownModule,
        Dialog,
        Tooltip
    ],
    template: `

<!--            <div class="grid">-->
<!--                <div class="col-12">-->
<!--                    <h2 class="text-color-primary">Liste des Trajets</h2>-->
<!--                    <p>Voici la liste des trajets</p>-->
<!--                    <p-button (onClick)="openAddDialog()" label="Add Trajet" [rounded]="true"></p-button>-->
<!--                </div>-->
<!--                <div class="col-12">-->
<!--                    <div class="flex justify-content-end">-->
<!--              <span class="p-input-icon-left">-->
<!--                <i class="pi pi-search"></i>-->
<!--                <input type="text" [formControl]="searchControl" placeholder="{{trajetSearchTextPlaceholder}}" pInputText />-->
<!--              </span>-->
<!--                        <p-button (onClick)="menu.toggle($event)" class="ml-2" icon="pi pi-sliders-h"></p-button>-->
<!--                        <p-menu #menu [model]="menuItems" [popup]="true"></p-menu>-->
<!--                    </div>-->
<!--                </div>-->
<!--                <div class="col-12">-->
<!--                    <p-divider></p-divider>-->
<!--                </div>-->
<!--                <ng-container *ngIf="filteredTrajets$ | async as trajets; else loading" >-->
<!--                    <ng-container *ngIf="trajets.length > 0; else noTrajets">-->
<!--                        <div *ngFor="let trajet of trajets; trackBy: trackById" class="col-12 xl:col-6 md:col-6">-->
<!--                            &lt;!&ndash;                            <app-employee-item&ndash;&gt;-->
<!--                            &lt;!&ndash;                                [employee]="employee"&ndash;&gt;-->
<!--                            &lt;!&ndash;                                (onEdit)="openEditDialog($event)"&ndash;&gt;-->
<!--                            &lt;!&ndash;                                (onDelete)="deleteEmployee($event)"&ndash;&gt;-->
<!--                            &lt;!&ndash;                                (onShow)="openShowDialog($event)"&ndash;&gt;-->
<!--                            &lt;!&ndash;                            ></app-employee-item>&ndash;&gt;-->
<!--                        </div>-->
<!--                    </ng-container>-->
<!--                </ng-container>-->

<!--                &lt;!&ndash;Templates Start&ndash;&gt;-->
<!--                <ng-template #noTrajets>-->
<!--                    <div class="card col-12 text-center">-->
<!--                        <div class="text-3xl font-bold text-xl mb-3 title">-->
<!--                            {{noTrajetFound}}-->
<!--                        </div>-->
<!--                    </div>-->
<!--                </ng-template>-->
<!--                <ng-template #loading>-->
<!--                    <div class="card col-12 text-center">-->
<!--                        <div class="text-3xl font-bold text-xl mb-3 title">-->
<!--                            {{loadingMessage}}-->
<!--                        </div>-->
<!--                    </div>-->
<!--                </ng-template>-->
<!--                &lt;!&ndash;Templates End&ndash;&gt;-->

<!--            </div>-->







<!--            <p-dialog-->
<!--                [header]="dialogTitle"-->
<!--                [modal]="true"-->
<!--                [(visible)] = "isEmployeeDialogOn"-->
<!--                [breakpoints]="{ '1199px': '75vw', '575px': '90vw' }"-->
<!--                [style]="{ width: '50vw' }"-->
<!--                [maximizable]="true"-->
<!--            >-->

<!--             <form [formGroup]="trajetForm" (ngSubmit)="onSubmit()">-->
<!--            <p-divider align="left" type="solid">Informations du trajet</p-divider>-->
<!--            <div class="grid">-->
<!--                <div class="col-12 md:col-6">-->
<!--                    <div class="flex flex-column">-->
<!--                        <label class="mb-2 required-asterisk" for="name">Nom</label>-->
<!--                        <input formControlName="name" pInputText id="name">-->
<!--                    </div>-->
<!--                </div>-->
<!--                <div class="col-12 md:col-6">-->
<!--                    <div class="flex flex-column">-->
<!--                        <label class="mb-2 required-asterisk" for="lastName">Tarif</label>-->
<!--                        <input formControlName="lastName" pInputText id="lastName">-->
<!--                    </div>-->
<!--                </div>-->
<!--                <div class="col-12 md:col-6">-->
<!--                    <div class="flex flex-column">-->
<!--                        <label class="mb-2 required-asterisk" for="email">Agence de depart</label>-->
<!--                        <input formControlName="startAgenceName" pInputText id="startAgenceName">-->
<!--                    </div>-->
<!--                </div>-->
<!--                <div class="col-12 md:col-6">-->
<!--                    <div class="flex flex-column">-->
<!--                        <label class="mb-2 required-asterisk" for="dateOfBirth">Agence d'arrive</label>-->
<!--                        <input formControlName="endAgenceName" pInputText id="endAgenceName">-->
<!--                    </div>-->
<!--                </div>-->
<!--            </div>-->
<!--            <p-divider></p-divider>-->
<!--            <div class="flex justify-content-end gap-2">-->
<!--                <p-button *ngIf="dialogOpenState === 'SHOW'" icon="pi pi-pencil" (onClick)="editMode()" label = "active edit mode"></p-button>-->
<!--                <p-button *ngIf="dialogOpenState !== 'SHOW'" icon="{{isSubmitButtonOn?'pi pi-spin pi-spinner': 'pi pi-send'}}" [disabled]="isSubmitButtonOn" label="Save" type="submit"  />-->
<!--            </div>-->
<!--        </form>-->
<!--            </p-dialog>-->


            <div class="card">
            <p-table [value]="trajets" [tableStyle]="{ 'min-width': '50rem' }">
                <ng-template #header>
                    <tr>
                        <th><strong>NOM</strong></th>
                        <th><strong>DEPART</strong></th>
                        <th><strong>ARRIVEE</strong></th>
                        <th><strong>TARIF</strong></th>
                        <th><strong>RESERVER</strong></th>
                        <th><strong>ACTION</strong></th>
                    </tr>
                </ng-template>
                <ng-template #body let-trajet>
                    <tr>
                        <td>{{ trajet.name }}</td>
                        <td>{{ trajet.startAgenceCity }}</td>
                        <td>{{ trajet.endAgenceCity }}</td>
                        <td>{{ trajet.price | currency: 'XAF' }}</td>
                        <td><p-button label="reserver"></p-button></td>
                        <td>
                            <i
                                pTooltip="Edit"
                                tooltipPosition="top"
                                class="pi pi-fw pi-pencil cursor-pointer mr-2 text-color-primary"
                            ></i>
                            <i
                                pTooltip="Delete"
                                tooltipPosition="top"
                                class="pi pi-fw pi-trash cursor-pointer mr-2 text-red-600"
                            ></i>
                        </td>
                    </tr>
                </ng-template>
            </p-table>
        </div>
    `
})
export class PanelsDemo implements OnInit {
    items: MenuItem[] = [
        {
            label: 'Save',
            icon: 'pi pi-check'
        },
        {
            label: 'Update',
            icon: 'pi pi-upload'
        },
        {
            label: 'Delete',
            icon: 'pi pi-trash'
        },
        {
            label: 'Home Page',
            icon: 'pi pi-home'
        }
    ];

    trajets!: Trajet[];
    trajetForm!: FormGroup;
    protected isSubmitButtonOn:  boolean = false;
    public dialogOpenState!: 'SHOW' | 'EDIT' | 'ADD';
    public dialogTitle: string = "Creation d'un trajet";
    public isEmployeeDialogOn: boolean = false;
    private trajetSearch: TrajetSearch = "SearchByName";
    private currentSearchText: string = "";
    protected filteredTrajets$!: Observable<Trajet[]>;
    public searchControl: FormControl<string> = new FormControl();
    public trajetSearchTextPlaceholder: string = "Search by name...";
    public menuItems: MenuItem[] = [
        {
            label: 'Search by Name',
            command: (): void => {
                this.trajetSearchTextPlaceholder="Search by Name..."
                this.trajetSearch = 'SearchByName'
                this.filterEmployees()
            }
        },
        {
            label: 'Search by SearchByAgenceName',
            command: (): void =>{
                this.trajetSearchTextPlaceholder="Search by SearchByAgenceName..."
                this.trajetSearch = 'SearchByAgenceName'
                this.filterEmployees()
            }
        },
        {
            label: 'Search by SearchByAgenceCity',
            command: (): void => {
                this.trajetSearchTextPlaceholder="Search by SearchByAgenceCity..."
                this.trajetSearch = 'SearchByAgenceCity'
                this.filterEmployees()
            }
        },
    ];

    public noTrajetFound: string = 'no Trajets found';
    loadingMessage: string = "Loading...";

    public trackById(index: number, item: Trajet): number | undefined {
        return item.id;
    }

    constructor(private trajetService: TrajetService){}

    ngOnInit(): void {
        this.trajetService.getAllTrajets().subscribe({
            next: data => {
                this.trajets = data;
            }
        })
    }

    public onSubmit(){
        if(!this.trajetForm.valid){
            this.trajetForm.markAllAsTouched();
            //this.messageService.add({ severity: 'error', summary: 'Error'});
        }else{
            this.isSubmitButtonOn = true;
            if(this.trajetForm.value.id){
                this.updateTrajet();
            }else{
                this.createTrajet();
            }
        }
    }

    public editMode(): void{
        this.dialogOpenState = "EDIT";
        this.dialogTitle = "Updating employee "+this.trajetForm.value.name;
        this.trajetForm.enable();
    }

    public updateTrajet() {

    }

    public createTrajet() {

    }

    private filterEmployees(): void {
        const filtered: Trajet[] = this.trajets?.filter((trajet: Trajet): boolean =>{
            if(this.trajetSearch === 'SearchByName'){
                return trajet.name.toLowerCase().includes(this.currentSearchText.toLowerCase())
            }else if(this.trajetSearch === 'SearchByAgenceName'){
                return trajet.startAgenceName.toLowerCase().includes(this.currentSearchText.toLowerCase()) ||
                    trajet.endAgenceName.toLowerCase().includes(this.currentSearchText.toLowerCase())
            }else if(this.trajetSearch === 'SearchByAgenceCity'){
                return trajet.startAgenceCity.toLowerCase().includes(this.currentSearchText.toLowerCase()) ||
                    trajet.endAgenceCity.toLowerCase().includes(this.currentSearchText.toLowerCase())
            }else{
                return false
            }

        });
        this.filteredTrajets$ = of(filtered);
    }

    public openAddDialog(): void {
        this.dialogTitle = "Add new Trajet";
        this.dialogOpenState = 'ADD';
        this.trajetForm.enable();
        this.trajetForm.reset();
        this.isEmployeeDialogOn = true;
    }
}
