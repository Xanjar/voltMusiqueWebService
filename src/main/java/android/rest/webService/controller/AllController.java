package android.rest.webService.controller;

import android.rest.webService.dao.album.AlbumRepository;
import android.rest.webService.dao.musique.MusiqueRepository;
import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.musique.Musique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/all")
public class AllController {

    @Autowired
    private MusiqueRepository musiqueRepository;

    @GetMapping("/musiques")
    public ResponseEntity<List<Musique>> recupAlbums() {
        List<Musique> list = musiqueRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
