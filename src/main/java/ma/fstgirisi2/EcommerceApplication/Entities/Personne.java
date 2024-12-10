package ma.fstgirisi2.EcommerceApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;

    public Personne(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public Personne() {

    }
}
