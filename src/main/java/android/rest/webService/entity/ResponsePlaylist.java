package android.rest.webService.entity;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.playlist.Playlist;
import android.rest.webService.domain.utilisateur.Utilisateur;

public class ResponsePlaylist {
    private Playlist playlist;
    private Utilisateur utilisateur;

    public ResponsePlaylist(Playlist playlist, Utilisateur utilisateur) {
        this.playlist = playlist;
        this.utilisateur = utilisateur;

        this.utilisateur.setAimeAlbums(null);
        this.utilisateur.setAimeMusiques(null);
        this.utilisateur.setAlbums(null);
        this.utilisateur.setMusiques(null);
        this.utilisateur.setPlaylists(null);
        this.utilisateur.setFeaturing(null);

        this.playlist.setMusiques(null);
        this.playlist.setUtilisateur(null);
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
