package ma.fstgirisi2.EcommerceApplication.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCours;
    private String nomCours;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    @JsonManagedReference
    private Departement departement;

    @ManyToMany(mappedBy = "cours")
    @JsonManagedReference
    private List<Etudiant> etudiants;

    public Cours(int idCours, String nomCours, int credits, Departement departement, List<Etudiant> etudiants) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.credits = credits;
        this.departement = departement;
        this.etudiants = etudiants;
    }

    public Cours() {

    }
}
