import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Client} from '../models/client';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private readonly apiUrl: string = "http://localhost:8080/clients";

  constructor(private http: HttpClient) { }

  public registerClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.apiUrl, client);
  }
}

