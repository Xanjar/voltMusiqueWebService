package android.rest.webService.domain.album;

import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idalbum;

    @NotNull
    @Size(max = 255)
    private String titre;


    @Size(max = 400)
    private String description;

    private Date dateSortie;

    @ManyToOne
    @JoinColumn(name="idutilisateur", nullable=false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy="album")
    private Set<Musique> musiques;

    @ManyToMany(mappedBy = "aimeAlbums")
    private Set<Utilisateur> aimer;

    public Album() {
    }

    public Album(@NotNull @Size(max = 255) String titre, @Size(max = 400) String description, Date dateSortie, Utilisateur utilisateur) {
        this.idalbum = idalbum;
        this.titre = titre;
        this.description = description;
        this.dateSortie = dateSortie;
        this.utilisateur = utilisateur;
    }

    public Long getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(Long idalbum) {
        this.idalbum = idalbum;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Musique> getMusiques() {
        return musiques;
    }

    public void setMusiques(Set<Musique> musiques) {
        this.musiques = musiques;
    }

    public Set<Utilisateur> getAimer() {
        return aimer;
    }

    public void setAimer(Set<Utilisateur> aimer) {
        this.aimer = aimer;
    }

}
