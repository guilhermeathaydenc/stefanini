/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.user.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stefanini.backend.user.exception.UserNotFoundException;
import br.com.stefanini.backend.user.model.User;
import br.com.stefanini.backend.user.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Setter;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

@Setter
@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("user")
    public ResponseEntity<User> user()
    {
        User u = new User();
        return ResponseEntity.ok(u);
    }
	
	//	Retorna o token de acesso da API (JWT) com as informações do usuário logado.
	@PostMapping("/api/signin")
    public ResponseEntity<String> getToken(@RequestBody User user) throws ServletException {
 
        String jwttoken = "";
 
        if(user.getLogin().isEmpty() || user.getPassword().isEmpty())
            return new ResponseEntity<String>("Login ou password não pode ser vázio.", HttpStatus.BAD_REQUEST);
 
        String login = user.getLogin(), 
               password = user.getPassword();
 
        if(!(login.equalsIgnoreCase("stefanini") && password.equalsIgnoreCase("123456")))
            return new ResponseEntity<String>("Invalid login or password.", HttpStatus.UNAUTHORIZED);
        else {
         // Obtendo o token JWT usando as credenciais do usuário.
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("usr", user.getLogin());
            claims.put("sub", "Authentication token");
            claims.put("rol", "Administrator, Developer");
            claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
 
            jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "secretKey").compact();
            System.out.println("Retornando o token a seguir para o usuário= "+ jwttoken);
        }
 
        return new ResponseEntity<String>(jwttoken, HttpStatus.OK);
    }
 
 // Listar todos os usuários.
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
//	Cadastrar um novo usuário.
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
//	Buscar um usuário pelo id.
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("user id: " + id + " not found!");

		return user.get();
	}
	
//	Remover um usuário pelo id.
	@DeleteMapping("/user/{id}")
	public void removeUser(@PathVariable long id) {
		userRepository.deleteById(id);
	}
		
//	Atualizar um usuário pelo id.
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id, @PathVariable String login, @PathVariable String password) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		user.setLogin(login);
		user.setPassword(password);

		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}
}