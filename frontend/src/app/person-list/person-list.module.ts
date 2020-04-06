 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PersonListComponent } from '../person-list/person-list.component';
import { PersonListRoutingModule } from './person-list-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    PersonListRoutingModule
  ],
  providers: [
  ],
  exports: [],
  declarations: [
    PersonListComponent
  ]
})
export class PersonListModule { }