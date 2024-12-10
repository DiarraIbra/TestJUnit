package ma.fstgirisi2.EcommerceApplication.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartement;

    public Departement(int idDepartement, String nomDepartement, List<Cours> cours) {
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
        this.cours = cours;
    }

    private String nomDepartement;



    @OneToMany(mappedBy = "departement")
    @JsonBackReference
    private List<Cours> cours;

    public Departement() {

    }

}
