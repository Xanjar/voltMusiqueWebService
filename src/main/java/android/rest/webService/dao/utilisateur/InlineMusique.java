package android.rest.webService.dao.utilisateur;

import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "inlineMusique", types = { Utilisateur.class })
public interface InlineMusique {
    Long getIdutilisateur();
    Set<Musique> getMusiques();
    String getPseudo();
}

