package android.rest.webService.security;

import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.utilisateur.Utilisateur;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UtilisateurRepository repository;

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager,UtilisateurRepository repository) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        setFilterProcessesUrl("/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Utilisateur creds = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(),new ArrayList<>()));
        }
        catch(IOException e) {
        throw new RuntimeException("Could not read request" + e);
        }
    }
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) {
        String token = Jwts.builder().setSubject(((User) authentication.getPrincipal()).getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
        .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".getBytes())
        .compact();
        response.addHeader("Authorization","Bearer " + token);
        Utilisateur u = repository.findByEmail(((User)authentication.getPrincipal()).getUsername()).get(0);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(
                    "{"+
                            "\"idutilisateur\":\"" + u.getIdutilisateur() + "\"," +
                            "\"pseudo\":\"" + u.getPseudo() + "\"," +
                            "\"email\":\"" + u.getEmail() + "\"," +
                            "\"nom\":\"" + u.getNom() + "\"," +
                            "\"prenom\":\"" + u.getPrenom() + "\"," +
                            "\"date_naissance\":\"" + u.getDateNaissance() + "\"," +
                            "\"num_etu\":\"" + u.getNumEtu() + "\"," +
                            "\"role\":\"" + u.getRole() + "\"" +
                            "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}