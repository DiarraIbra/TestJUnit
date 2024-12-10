package ma.fstgirisi2.EcommerceApplication.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String specialite;


    private String nom;

    @ManyToMany
    @JoinTable(
            name = "etudiant_cours",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    @JsonBackReference
    private List<Cours> cours;

    public Etudiant(int idEtudiant, String specialite, Cours cours) {
        this.idEtudiant = idEtudiant;
        this.specialite = specialite;
        this.cours = (List<Cours>) cours;
    }

    public Etudiant() {

    }
}
