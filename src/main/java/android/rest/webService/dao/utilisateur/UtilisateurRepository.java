package android.rest.webService.dao.utilisateur;

import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>, UtilisateurRepositoryCustom {

}
