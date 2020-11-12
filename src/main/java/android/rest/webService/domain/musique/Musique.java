package android.rest.webService.domain.musique;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.plainte.Plainte;
import android.rest.webService.domain.playlist.Playlist;
import android.rest.webService.domain.utilisateur.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "musique")
public class Musique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusique;

    @NotNull
    @Size(max = 255)
    private String titre;

    @NotNull
    private Date dateSortie;

    @ManyToOne
    @JoinColumn(name="idutilisateur", nullable=false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idalbum", nullable=false)
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "featuring",
            joinColumns = @JoinColumn(name = "idmusique"),
            inverseJoinColumns = @JoinColumn(name = "idutilisateur"))
    private Set<Utilisateur> feats;

    @ManyToMany(mappedBy = "aimeMusiques")
    private Set<Utilisateur> aimer;

    @OneToMany(mappedBy="musique")
    private Set<Plainte> plaintes;

    @ManyToMany(mappedBy = "musiques")
    private Set<Playlist> playlists;

    public Musique() {
    }

    public Musique(Long idMusique, @NotNull @Size(max = 255) String titre, @NotNull Date dateSortie, Utilisateur utilisateur, Album album) {
        this.idMusique = idMusique;
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.utilisateur = utilisateur;
        this.album = album;
    }

    public Long getIdMusique() {
        return idMusique;
    }

    public void setIdMusique(Long idMusique) {
        this.idMusique = idMusique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Utilisateur> getFeats() {
        return feats;
    }

    public void setFeats(Set<Utilisateur> feats) {
        this.feats = feats;
    }

    public Set<Utilisateur> getAimer() {
        return aimer;
    }

    public void setAimer(Set<Utilisateur> aimer) {
        this.aimer = aimer;
    }

    public Set<Plainte> getPlaintes() {
        return plaintes;
    }

    public void setPlaintes(Set<Plainte> plaintes) {
        this.plaintes = plaintes;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
}
