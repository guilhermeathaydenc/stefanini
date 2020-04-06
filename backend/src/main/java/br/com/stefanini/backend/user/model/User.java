/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue
	@Getter private Long id;
	@Getter @Setter private String login;
	@Getter @Setter private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}