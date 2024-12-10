package ma.fstgirisi2.EcommerceApplication.Entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnseignantTest {

    @Test
    void testConstructorWithAllFields() {
        // Arrange
        int id = 1;
        String nom = "John Doe";
        String email = "john.doe@example.com";
        String matiere = "Mathematics";

        // Act
        Enseignant enseignant = new Enseignant(id, nom, email, matiere);

        // Assert
        assertEquals(id, enseignant.getId());
        assertEquals(nom, enseignant.getNom());
        assertEquals(email, enseignant.getEmail());
        assertEquals(matiere, enseignant.getMatiere());
    }

    @Test
    void testConstructorWithMatiereOnly() {
        // Arrange
        String matiere = "Physics";

        // Act
        Enseignant enseignant = new Enseignant(matiere);

        // Assert
        assertNull(enseignant.getNom());
        assertNull(enseignant.getEmail());
        assertEquals(matiere, enseignant.getMatiere());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        Enseignant enseignant = new Enseignant();

        // Assert
        assertNull(enseignant.getNom());
        assertNull(enseignant.getEmail());
        assertNull(enseignant.getMatiere());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        Enseignant enseignant = new Enseignant();
        int id = 2;
        String nom = "Jane Smith";
        String email = "jane.smith@example.com";
        String matiere = "Chemistry";

        // Act
        enseignant.setId(id);
        enseignant.setNom(nom);
        enseignant.setEmail(email);
        enseignant.setMatiere(matiere);

        // Assert
        assertEquals(id, enseignant.getId());
        assertEquals(nom, enseignant.getNom());
        assertEquals(email, enseignant.getEmail());
        assertEquals(matiere, enseignant.getMatiere());
    }
}
