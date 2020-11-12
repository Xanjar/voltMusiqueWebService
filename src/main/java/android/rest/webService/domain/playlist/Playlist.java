package android.rest.webService.domain.playlist;

import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idplaylist;

    @NotNull
    @Size(max = 255)
    private String titre;

    @ManyToOne
    @JoinColumn(name="idutilisateur", nullable=false)
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable(
            name = "playlist_musique",
            joinColumns = @JoinColumn(name = "idplaylist"),
            inverseJoinColumns = @JoinColumn(name = "idmusique"))
    private Set<Musique> musiques;

    public Playlist() {
    }

    public Playlist(@NotNull @Size(max = 255) String titre, Utilisateur utilisateur) {
        this.idplaylist = idplaylist;
        this.titre = titre;
        this.utilisateur = utilisateur;
    }

    public Long getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(Long idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Utilisateur getutilisateur() {
        return utilisateur;
    }

    public void setutilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Musique> getMusiques() {
        return musiques;
    }

    public void setMusiques(Set<Musique> musiques) {
        this.musiques = musiques;
    }
}
