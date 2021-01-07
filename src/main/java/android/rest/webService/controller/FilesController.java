package android.rest.webService.controller;

import android.rest.webService.dao.album.AlbumRepository;
import android.rest.webService.dao.musique.MusiqueRepository;
import android.rest.webService.dao.utilisateur.UtilisateurRepository;
import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Role;
import android.rest.webService.domain.utilisateur.Utilisateur;
import android.rest.webService.service.storage.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.Date;

@RestController
@RequestMapping(value = "/file")
public class FilesController {
    @Autowired
    FileStorageService storageService;
    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private MusiqueRepository musiqueRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("titre") String titre, @RequestParam("idalbum")Long idAlbum) {
        String message = "";
        Musique musique = new Musique();
        musique.setDateSortie(new Date());
        musique.setTitre(titre);
        musique.setUtilisateur(userRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .get(0));
        musique.setAlbum(albumRepository.getOne(idAlbum));
        musique = musiqueRepository.save(musique);
        Utilisateur utilisateur = musique.getUtilisateur();
        try {
            storageService.save(file,musique.getIdMusique()+"");
            musique.setPath(musique.getIdMusique()+"."+FilenameUtils.getExtension(file.getOriginalFilename()));
            musiqueRepository.save(musique);
            utilisateur.setRole(Role.MUSICIAN);
            userRepository.save(utilisateur);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            musiqueRepository.deleteById(musique.getIdMusique());
            message = "Could not upload the file: " + file.getOriginalFilename()+ "!"+ e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("idmusique")Long idMusique) {
        Musique musique = musiqueRepository.getOne(idMusique);
        try {
            Resource file = storageService.load(musique.getPath());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

}
