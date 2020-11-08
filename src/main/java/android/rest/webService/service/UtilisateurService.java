package android.rest.webService.service;

import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService {

    @Autowired
    private UtilisateurRepository repository;

    @Override
    public List<Utilisateur> findAll() {
        return repository.findAll();
    }
}
