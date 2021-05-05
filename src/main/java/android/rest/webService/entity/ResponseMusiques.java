package android.rest.webService.entity;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Utilisateur;

public class ResponseMusiques {
    Musique musique;
    Album album;
    Utilisateur utilisateur;

    public ResponseMusiques(Musique musique, Album album, Utilisateur utilisateur) {
        this.musique = musique;
        this.album = album;
        this.utilisateur = utilisateur;
        this.album.setUtilisateur(null);
        this.album.setMusiques(null);
        this.album.setAimer(null);
        this.utilisateur.setAimeAlbums(null);
        this.utilisateur.setAimeMusiques(null);
        this.utilisateur.setAlbums(null);
        this.utilisateur.setMusiques(null);
        this.utilisateur.setPlaylists(null);
        this.utilisateur.setFeaturing(null);
        this.musique.setAimer(null);
        this.musique.setUtilisateur(null);
        this.musique.setFeats(null);
        this.musique.setPlaintes(null);
        this.musique.setPlaylists(null);
        this.musique.setAlbum(null);
    }

    public Musique getMusique() {
        return musique;
    }

    public void setMusique(Musique musique) {
        this.musique = musique;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
