 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
import { PersonResource } from "../person-list/person";

export class PersonListResource {
    person: PersonResource;
    constructor(values: Object = {}) {
        this.person = new PersonResource(values["person"]);
    }
}