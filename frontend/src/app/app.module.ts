/**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
import { FormsModule } from '@angular/forms';
import { SharedModule } from './shared/shared.module';
import { MyOAuthModule } from 'myoauth-ng';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { environment } from 'src/environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule, MatIconModule, MatToolbarModule } from '@angular/material';
import { LoginComponent } from './login/login.component';
import { PersonAddComponent } from './person-add/person-add.component';
import { PersonEditComponent } from './person-edit/person-edit.component';
import { PersonListComponent } from '../app/person-list/person-list.component';
import { UserAddComponent } from './user-add/user-add.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { UserListComponent } from './user-list/user-list.component';
import { LoginService } from "../app/login/login.service";
import { ReactiveFormsModule } from "@angular/forms";
import { routing } from "../app/app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PersonAddComponent,
    PersonEditComponent,
    PersonListComponent,
    UserAddComponent,
    UserEditComponent,
    UserListComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    SharedModule,
    MyOAuthModule.forRoot(environment.oauth),
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatToolbarModule,
    BrowserAnimationsModule
  ],
  providers: [
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }