package android.rest.webService.domain.utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Size(max = 20)
    private String numEtu;

    public Utilisateur() {
    }

    public Utilisateur(Long idutilisateur, @NotNull @Size(max = 50) String pseudo, @Size(max = 255) String nom, @Size(max = 255) String prenom, @NotNull @Size(max = 255) String email, Date dateNaissance, @NotNull Role role, @Size(max = 20) String numEtu) {
        this.idutilisateur = idutilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.numEtu = numEtu;
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
}
