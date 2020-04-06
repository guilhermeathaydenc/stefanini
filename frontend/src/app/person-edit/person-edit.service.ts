/**
 * #solution   : STEFANINI (front-end)

 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from '../model/person.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonEditService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8084/login';

  login(loginPayload) {
    const headers = {
      'Authorization': 'Basic ' + btoa('stefaninifrontend:stefanini2020'),
      'Content-type': 'application/x-www-form-urlencoded'
    }
    return this.http.post('http://localhost:8084/' + 'oauth/token', loginPayload, {headers});
  }

  updatePerson(person: Person): Observable<any> {
    return this.http.put(this.baseUrl + 'person/' + person.id, person);
  }

  deletePerson(id: number){
    return this.http.delete(this.baseUrl + 'person/' + id);
  }

  getPersonById(id: number) {
    return this.http.get(this.baseUrl + 'persons/' + id);
  }

}