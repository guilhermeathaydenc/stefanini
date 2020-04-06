 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
import { inject, TestBed } from '@angular/core/testing';
import { PersonListService } from './person-list.service';

describe('PersonListService', () => {
  beforeEach(() => TestBed.configureTestingModule({providers: [PersonListService]}));

  it('should be created', inject([PersonListService], (service: PersonListService) => {
    expect(service).toBeTruthy();
  }));
});