import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Trajet} from "../models/trajet";

@Injectable({
  providedIn: 'root'
})
export class TrajetService {
    private readonly apiUrl = 'http://localhost:8080/trajets';

    constructor(private http: HttpClient) {
    }

    public getAllTrajets() : Observable<Trajet[]> {
        return this.http.get<Trajet[]>(`${this.apiUrl}`);
    }

    public createTrajet(trajet: Trajet): Observable<Trajet>{
        return this.http.post<Trajet>(`${this.apiUrl}`, trajet);
    }

    public deleteTrajet(id: number): Observable<void>{
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }

    public updateTrajet(id: number, trajet: Trajet): Observable<Trajet>{
        return this.http.put<Trajet>(`${this.apiUrl}/${id}`, trajet);
    }
}
