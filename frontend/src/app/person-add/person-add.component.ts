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
import { PersonAddService } from '../person-add/person-add.service';

@Component({
  selector: 'app-person-add',
  templateUrl: './person-add.component.html',
  styleUrls: ['./person-add.component.css']
})
export class PersonAddComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private personAddService: PersonAddService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      email: ['', Validators.required],
      birthday: ['', Validators.required],
      cpf: ['', Validators.required]
    });

  }

  onSubmit() {
    this.personAddService.createPerson(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['person-list']);
      });
  }

}