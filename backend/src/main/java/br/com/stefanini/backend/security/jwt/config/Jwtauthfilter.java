/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */

package br.com.stefanini.backend.security.jwt.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */
 
// Essa classe é criada para validar o token de autenticação jwt.
// Se o token for válido, as solicitações para o URL protegido serão veiculadas e a resposta será devolvida ao usuário.
// Se o token não for válido, uma exceção será lançada para o usuário.

public class Jwtauthfilter extends OncePerRequestFilter {
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer";
	private final String SECRET = "mySecretKey";
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
 
        // Buscando o cabeçalho de autorização da solicitação.
        // Este cabeçalho conterá o token do portador que possui o token jwt.
        String authenticationHeader= request.getHeader(HEADER);
 
        try {
            SecurityContext context= SecurityContextHolder.getContext();
 
            if(authenticationHeader != null && authenticationHeader.startsWith("Bearer")) {
 
                final String bearerTkn= authenticationHeader.replaceAll(PREFIX, "");
                System.out.println("O token a seguir é recebido do URL protegido= "+ bearerTkn);
 
                try {
                    // Analisando o token jwt.
                    Jws<Claims> claims = Jwts.parser().requireIssuer(PREFIX).setSigningKey(SECRET).parseClaimsJws(bearerTkn);
 
                    // Obtendo as reivindicações do token jwt analisado.
                    String user= (String) claims.getBody().get("usr");
                    String roles= (String) claims.getBody().get("rol");
 
                    // Criando a lista de autoridades concedidas para as funções recebidas.
                    List<GrantedAuthority> authority= new ArrayList<GrantedAuthority>();
                    for(String role: roles.split(","))
                        authority.add(new SimpleGrantedAuthority(role));
 
                    // Criando um objeto de autenticação usando as declarações.
                    Myauthtoken authenticationTkn= new Myauthtoken(user, null, authority);
                    // Armazenando o objeto de autenticação no contexto de segurança.
                    context.setAuthentication(authenticationTkn);
                } catch (SignatureException e) {
                    throw new ServletException("Token inválido.");
                }
            }
 
            filterChain.doFilter(request, response);
            context.setAuthentication(null);
        } catch(AuthenticationException ex) {
            throw new ServletException("Exceção de autenticação.");
        }
    }
}