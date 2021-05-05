package android.rest.webService.controller;

import android.rest.webService.dao.album.AlbumRepository;
import android.rest.webService.dao.playlist.PlaylistRepository;
import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.playlist.Playlist;
import android.rest.webService.entity.ResponseAlbums;
import android.rest.webService.entity.ResponsePlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/me")
public class MeController {
    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/albums")
    public ResponseEntity<List<ResponseAlbums>> recupAlbums() {
        List<Album> list = albumRepository.findByUtilisateur(userRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .get(0));

        List<ResponseAlbums> responseAlbums = new ArrayList<>();
        for (Album album:list) {
            responseAlbums.add(new ResponseAlbums(album,album.getUtilisateur()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseAlbums);
    }

    @GetMapping("/playlists")
    public ResponseEntity<List<ResponsePlaylist>> recupPlaylist() {
        List<Playlist> list = playlistRepository.findByUtilisateur(userRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .get(0));
        List<ResponsePlaylist> responsePlaylists = new ArrayList<>();
        for (Playlist playlist:list) {
            responsePlaylists.add(new ResponsePlaylist(playlist,playlist.getUtilisateur()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsePlaylists);
    }
}
