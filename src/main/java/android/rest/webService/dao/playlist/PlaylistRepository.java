package android.rest.webService.dao.playlist;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.playlist.Playlist;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>, PlaylistRepositoryCustom {
    List<Playlist> findByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
}
