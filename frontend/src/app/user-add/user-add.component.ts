/**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private loginService: LoginService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      login: ['', Validators.required],
      password: ['', Validators.required]
    });

  }

  onSubmit() {
    this.loginService.createUser(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['user-list']);
      });
  }
}