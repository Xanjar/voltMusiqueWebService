package android.rest.webService.dao.playlist;

import android.rest.webService.domain.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>, PlaylistRepositoryCustom {
}
