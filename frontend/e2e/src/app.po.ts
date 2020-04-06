/**
 * #solution   : STEFANINI (front-end)

 * #author     : guilherme.athayde.nc@gmail.com
 * #phone      : 81 99687.3959
 * #profession : senior full stack developer analyst
 * #date       : 05/04/2020
 */

import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getTitleText() {
    return element(by.css('app-root h1')).getText();
  }
}
