package android.rest.webService.controller;

import android.rest.webService.dao.album.AlbumRepository;
import android.rest.webService.dao.playlist.PlaylistRepository;
import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.playlist.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping(value = "/ajout")
public class AjoutController {

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @PostMapping("/album")
    public ResponseEntity<String> ajoutAlbum(@RequestParam("description") String description, @RequestParam("titre") String titre) {
        Album album = new Album();
        album.setDescription(description);
        album.setTitre(titre);
        album.setDateSortie(new Date());
        album.setUtilisateur(userRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .get(0));
        try {
            albumRepository.save(album);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Echec de l'ajout "+e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Album ajouté");
    }

    @PostMapping("/playlist")
    public ResponseEntity<String> ajoutAlbum(@RequestParam("titre") String titre) {
        Playlist playlist = new Playlist();
        playlist.setTitre(titre);
        playlist.setUtilisateur(userRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .get(0));
        try {
            playlistRepository.save(playlist);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Echec de l'ajout "+e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Playlist ajouté");
    }
}
