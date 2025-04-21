import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {Button} from "primeng/button";

@Component({
  selector: 'app-home',
    imports: [
        CommonModule,
        Button
    ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
