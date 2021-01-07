package android.rest.webService.dao;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.plainte.Plainte;
import android.rest.webService.domain.playlist.Playlist;
import android.rest.webService.domain.utilisateur.Utilisateur;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Utilisateur.class);
        config.exposeIdsFor(Musique.class);
        config.exposeIdsFor(Album.class);
        config.exposeIdsFor(Playlist.class);
        config.exposeIdsFor(Plainte.class);

    }
}
