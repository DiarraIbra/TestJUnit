package ma.fstgirisi2.EcommerceApplication.Entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Enseignant extends Personne {
    private String matiere;

    public Enseignant(int id, String nom, String email, String matiere) {
        super(id, nom, email);
        this.matiere = matiere;
    }

    public Enseignant(String matiere) {
        this.matiere = matiere;
    }

    public Enseignant() {
        super();
    }
}
