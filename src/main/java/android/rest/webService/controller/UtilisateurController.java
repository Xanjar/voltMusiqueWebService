package android.rest.webService.controller;

import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {
    private UtilisateurRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UtilisateurController(UtilisateurRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/signup")
    public void signUp(@RequestBody Utilisateur user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
