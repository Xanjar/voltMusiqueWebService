package android.rest.webService.service.utilisateur;

import android.rest.webService.domain.utilisateur.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    List<Utilisateur> findAll();
}
