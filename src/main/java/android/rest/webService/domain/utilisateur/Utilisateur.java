package android.rest.webService.domain.utilisateur;

import android.rest.webService.domain.album.Album;
import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.playlist.Playlist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idutilisateur;

    @NotNull
    @Size(max = 50)
    private String pseudo;

    @Size(max = 255)
    private String nom;

    @Size(max = 255)
    private String prenom;

    @NotNull
    @Column(unique = true)
    @Size(max = 255)
    private String email;

    private Date dateNaissance;

    @Size(max = 255)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Size(max = 20)
    private String numEtu;

    @OneToMany(mappedBy="utilisateur")
    private Set<Playlist> playlists;

    @OneToMany(mappedBy="utilisateur")
    private Set<Album> albums;

    @OneToMany(mappedBy="utilisateur")
    private Set<Musique> musiques;

    @ManyToMany
    @JoinTable(
            name = "aimer_album",
            joinColumns = @JoinColumn(name = "idutilisateur"),
            inverseJoinColumns = @JoinColumn(name = "idalbum"))
    private Set<Album> aimeAlbums;

    @ManyToMany
    @JoinTable(
            name = "aimer_musique",
            joinColumns = @JoinColumn(name = "idutilisateur"),
            inverseJoinColumns = @JoinColumn(name = "idmusique"))
    private Set<Album> aimeMusiques;

    @ManyToMany(mappedBy = "feats")
    private Set<Musique> featuring;

    public Utilisateur() {
    }

    public Utilisateur(@NotNull @Size(max = 50) String pseudo, @Size(max = 255) String nom, @Size(max = 255) String prenom, @NotNull @Size(max = 255) String email, Date dateNaissance, @Size(max = 255) String password, @NotNull Role role, @Size(max = 20) String numEtu) {
        this.password = password;
        this.idutilisateur = idutilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.numEtu = numEtu;
        this.password = password;
    }

    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(String numEtu) {
        this.numEtu = numEtu;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlist) {
        this.playlists = playlist;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Musique> getMusiques() {
        return musiques;
    }

    public void setMusiques(Set<Musique> musiques) {
        this.musiques = musiques;
    }

    public Set<Album> getAimeAlbums() {
        return aimeAlbums;
    }

    public void setAimeAlbums(Set<Album> aimeAlbums) {
        this.aimeAlbums = aimeAlbums;
    }

    public Set<Album> getAimeMusiques() {
        return aimeMusiques;
    }

    public void setAimeMusiques(Set<Album> aimeMusiques) {
        this.aimeMusiques = aimeMusiques;
    }

    public Set<Musique> getFeaturing() {
        return featuring;
    }

    public void setFeaturing(Set<Musique> featuring) {
        this.featuring = featuring;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
