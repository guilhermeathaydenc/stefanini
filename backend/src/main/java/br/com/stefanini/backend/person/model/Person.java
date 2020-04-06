/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.person.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

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
public class Person {

	@Id
	@GeneratedValue
	@Getter private Long id;
	@Getter @Setter private String name;
	@Getter @Setter private String gender;
	@Getter @Setter private String email;
	@Getter @Setter private Date   birthday;
	@Getter @Setter private String naturalness;
	@Getter @Setter private String nationality;
	@Getter @Setter private String cpf;
	@Getter @Setter private Date registrationDate = new java.sql.Date(System.currentTimeMillis());
	@Getter @Setter private Date updateDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the naturalness
	 */
	public String getNaturalness() {
		return naturalness;
	}
	/**
	 * @param naturalness the naturalness to set
	 */
	public void setNaturalness(String naturalness) {
		this.naturalness = naturalness;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}