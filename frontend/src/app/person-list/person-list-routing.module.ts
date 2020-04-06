/**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from '../person-list/person-list.component';

const routes: Routes = [
  {
    path: 'persons',
    component: PersonListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonListRoutingModule { }