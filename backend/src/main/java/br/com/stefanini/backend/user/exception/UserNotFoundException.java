/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.user.exception;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4107721589669831719L;

	public UserNotFoundException(String exception) {
		super(exception);
	}
}