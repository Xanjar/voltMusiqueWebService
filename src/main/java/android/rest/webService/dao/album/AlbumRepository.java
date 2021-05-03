package android.rest.webService.dao.album;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>, AlbumRepositoryCustom{

    List<Album> findByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
}
