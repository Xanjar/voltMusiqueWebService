package android.rest.webService.dao.plainte;

import android.rest.webService.domain.plainte.Plainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainteRepository extends JpaRepository<Plainte,Long>, PlainteRepositoryCustom {
}
