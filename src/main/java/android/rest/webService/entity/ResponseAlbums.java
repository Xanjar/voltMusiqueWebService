package android.rest.webService.entity;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.utilisateur.Utilisateur;

public class ResponseAlbums {
    private Album album;
    private Utilisateur utilisateur;

    public ResponseAlbums(Album album, Utilisateur utilisateur) {
        this.album = album;
        this.utilisateur = utilisateur;
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
