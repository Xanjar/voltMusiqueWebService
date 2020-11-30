package android.rest.webService.service.utilisateur;

import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class UtilisateurDetailsServiceImpl implements UserDetailsService {
    private UtilisateurRepository userRepository;
    public UtilisateurDetailsServiceImpl(UtilisateurRepository utilisateurRepository){
        this.userRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByEmail(email).get(0);
        if(user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
