/**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../model/user.model';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  user: User;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    let userId = window.sessionStorage.getItem("editUserId");
    if(!userId) {
      alert("Invalid action.")
      this.router.navigate(['user-list']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      login: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.loginService.getUserById(+userId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.loginService.updateUser(this.editForm.value)
      .pipe()
      .subscribe(
        data => {
            alert('User updated successfully.');
            this.router.navigate(['user-list']);
        },
        error => {
          alert(error);
        });
  }
}