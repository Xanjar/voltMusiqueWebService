package android.rest.webService.service.musique;

import android.rest.webService.domain.musique.Musique;

import java.util.List;

public interface IMusiqueService {
    List<Musique> findAll();
}
