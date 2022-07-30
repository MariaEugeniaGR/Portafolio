import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{ 
    let headers = new HttpHeaders();
    headers.append('Content-Access-Control-Allow-Origin', '*');
    return this.http.get<persona>(this.URL+'3', {headers});
  }
}
