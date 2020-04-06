// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

/**
 * #solution   : STEFANINI (front-end)
 * #objective  : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 
 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8084',
  oauth: {
    token: 'http://localhost:8084/oauth/token',
    authorize: 'http://localhost:8084/login/oauth/authorize',
    state: '',
    remoteUser: 'stefanini',
    scope: 'read_profile_info',
    secret: 'stefanini2020',
    client_id: 'stefaninifrontend',
    response_type: 'code',
    redirectTo: 'http://localhost:4200'
  }
};