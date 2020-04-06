 /**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
export class PersonResource {
    id: string;
    name: string;
    gender: string;
    email: string;
    birthday: Date;
    naturalness: string;
    nationality: string;
    cpf: string;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}