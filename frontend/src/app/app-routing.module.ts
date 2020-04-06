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
import { LoginComponent } from './login/login.component';
import { UserAddComponent } from './user-add/user-add.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { UserListComponent } from './user-list/user-list.component';
import { PersonAddComponent } from './person-add/person-add.component';
import { PersonEditComponent } from './person-edit/person-edit.component';
import { PersonListComponent } from './person-list/person-list.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'user-add', component: UserAddComponent },
  { path: 'user-list', component: UserListComponent },
  { path: 'user-edit', component: UserEditComponent },
  { path: 'person-add', component: PersonAddComponent },
  { path: 'person-list', component: PersonListComponent },
  { path: 'person-edit', component: PersonEditComponent },
  { path : '', component : LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);