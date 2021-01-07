package android.rest.webService.dao.utilisateur;

import android.rest.webService.domain.utilisateur.Role;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "utilisateurs", path = "utilisateurs")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>, UtilisateurRepositoryCustom {

    @RestResource(path = "byemail", rel="findByEmail")
    List<Utilisateur> findByEmail(@Param("email") String emailAddress);

    @RestResource(path = "byrole", rel="findByRole")
    List<Utilisateur> findByRole(@Param("role") Role role);


}
