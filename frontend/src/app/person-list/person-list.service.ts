 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment'
import { Observable } from 'rxjs';
import { PersonListResource } from '../person-list/person-list';

export const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})

export class PersonListService {

  constructor(private http: HttpClient) { }

    public getPersons(id: string): Observable<PersonListResource> {
      return this.http.get<PersonListResource>('${API_URL}/persons', { "params": { "id": id }});
    }

  }