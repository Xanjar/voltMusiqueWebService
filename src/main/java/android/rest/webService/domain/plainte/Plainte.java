package android.rest.webService.domain.plainte;

import android.rest.webService.domain.musique.Musique;
import android.rest.webService.domain.utilisateur.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "plainte")
public class Plainte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplainte", nullable = false)
    private Long idPlainte;

    @NotNull
    @Size(max = 255)
    private String message;

    @NotNull
    private Date datePlainte;

    @ManyToOne
    @JoinColumn(name="idmusique", nullable=false)
    private Musique musique;

    public Plainte() {
    }

    public Plainte(@NotNull @Size(max = 255) String message, @NotNull Date datePlainte, Musique musique) {
        this.idPlainte = idPlainte;
        this.message = message;
        this.datePlainte = datePlainte;
        this.musique = musique;
    }

    public Long getIdPlainte() {
        return idPlainte;
    }

    public void setIdPlainte(Long idPlainte) {
        this.idPlainte = idPlainte;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatePlainte() {
        return datePlainte;
    }

    public void setDatePlainte(Date datePlainte) {
        this.datePlainte = datePlainte;
    }

    public Musique getMusique() {
        return musique;
    }

    public void setMusique(Musique musique) {
        this.musique = musique;
    }
}
