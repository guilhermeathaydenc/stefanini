/**
 * #solution   : STEFANINI (front-end)

 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8084/login';

  login(loginPayload) {
    const headers = {
      'Authorization': 'Basic ' + btoa('stefaninifrontend:stefanini2020'),
      'Content-type': 'application/x-www-form-urlencoded'
    }
    return this.http.post('http://localhost:8084/' + 'oauth/token', loginPayload, {headers});
  }

  getUsers() {
    return this.http.get(this.baseUrl + 'users?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }

  getUserById(id: number) {
    return this.http.get(this.baseUrl + 'users/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }

  createUser(user: User){
    return this.http.post(this.baseUrl + 'users?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, user);
  }

  updateUser(user: User): Observable<any> {
    return this.http.put(this.baseUrl + 'user/' + user.id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, user);
  }

  deleteUser(id: number){
    return this.http.delete(this.baseUrl + 'user/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }
}