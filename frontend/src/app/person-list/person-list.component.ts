 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { Component, OnInit } from '@angular/core';
import { PersonResource } from '../person-list/person';
import { PersonListResource } from '../person-list/person-list';
import { PersonListService } from '../person-list/person-list.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  person: PersonResource;
  resource: PersonListResource[];
  categories: Array<String> = [];

  constructor(private personListService: PersonListService) { }

  ngOnInit() {
    const date = new Date();
    console.log(date);
    this.resource = Array<PersonListResource>();
  }

}