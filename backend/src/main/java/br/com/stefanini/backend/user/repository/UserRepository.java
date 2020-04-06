/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */

package br.com.stefanini.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.backend.user.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	Optional<User> findById(Long id);
}