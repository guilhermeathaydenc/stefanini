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
import { PersonEditService } from '../person-edit/person-edit.service';
import { Person } from '../model/person.model';

@Component({
  selector: 'app-person-edit',
  templateUrl: './person-edit.component.html',
  styleUrls: ['./person-edit.component.css']
})
export class PersonEditComponent implements OnInit {

  person: Person;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private personEditService: PersonEditService) { }

  ngOnInit() {
    let personId = window.sessionStorage.getItem("editPersonId");
    if(!personId) {
      alert("Invalid action.")
      this.router.navigate(['person-list']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      email: ['', Validators.required],
      birthday: ['', Validators.required],
      cpf: ['', Validators.required]
    });
    this.personEditService.getPersonById(+personId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.personEditService.updatePerson(this.editForm.value)
      .pipe()
      .subscribe(
        data => {
            alert('Person updated successfully.');
            this.router.navigate(['person-list']);
        },
        error => {
          alert(error);
        });
  }
}