package android.rest.webService.dao.album;

import android.rest.webService.domain.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>, AlbumRepositoryCustom{
}
