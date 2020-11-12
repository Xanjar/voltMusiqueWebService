package android.rest.webService.dao.musique;

import android.rest.webService.domain.musique.Musique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusiqueRepository extends JpaRepository<Musique,Long>, MusiqueRepositoryCustom {
}
