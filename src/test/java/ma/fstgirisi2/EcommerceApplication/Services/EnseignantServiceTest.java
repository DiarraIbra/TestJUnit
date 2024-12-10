package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Enseignant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.EnseignantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnseignantServiceTest {

    @Mock
    private EnseignantRepository enseignantRepository;

    @InjectMocks
    private EnseignantService enseignantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEnseignants() {
        // Arrange
        List<Enseignant> enseignants = new ArrayList<>();
        enseignants.add(new Enseignant(1, "John Doe", "john.doe@example.com", "Mathematics"));
        enseignants.add(new Enseignant(2, "Jane Smith", "jane.smith@example.com", "Physics"));
        when(enseignantRepository.findAll()).thenReturn(enseignants);

        // Act
        List<Enseignant> result = enseignantService.getAllEnseignants();

        // Assert
        assertEquals(2, result.size());
        verify(enseignantRepository, times(1)).findAll();
    }

    @Test
    void testGetEnseignantById_Exists() throws ResourceNotFoundException {
        // Arrange
        int id = 1;
        Enseignant enseignant = new Enseignant(id, "John Doe", "john.doe@example.com", "Mathematics");
        when(enseignantRepository.findById(id)).thenReturn(Optional.of(enseignant));

        // Act
        Enseignant result = enseignantService.getEnseignantById(id);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getNom());
        verify(enseignantRepository, times(1)).findById(id);
    }

    @Test
    void testGetEnseignantById_NotFound() {
        // Arrange
        int id = 1;
        when(enseignantRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> enseignantService.getEnseignantById(id));
        verify(enseignantRepository, times(1)).findById(id);
    }

    @Test
    void testCreateEnseignant() {
        // Arrange
        Enseignant enseignant = new Enseignant(1, "John Doe", "john.doe@example.com", "Mathematics");
        when(enseignantRepository.save(enseignant)).thenReturn(enseignant);

        // Act
        Enseignant result = enseignantService.createEnseignant(enseignant);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getNom());
        verify(enseignantRepository, times(1)).save(enseignant);
    }

    @Test
    void testUpdateEnseignant() throws ResourceNotFoundException {
        // Arrange
        int id = 1;
        Enseignant existingEnseignant = new Enseignant(id, "John Doe", "john.doe@example.com", "Mathematics");
        Enseignant updatedEnseignant = new Enseignant(id, "Jane Smith", "jane.smith@example.com", "Physics");

        when(enseignantRepository.findById(id)).thenReturn(Optional.of(existingEnseignant));
        when(enseignantRepository.save(existingEnseignant)).thenReturn(existingEnseignant);

        // Act
        Enseignant result = enseignantService.updateEnseignant(id, updatedEnseignant);

        // Assert
        assertNotNull(result);
        assertEquals("Jane Smith", result.getNom());
        assertEquals("Physics", result.getMatiere());
        verify(enseignantRepository, times(1)).findById(id);
        verify(enseignantRepository, times(1)).save(existingEnseignant);
    }

    @Test
    void testDeleteEnseignant() throws ResourceNotFoundException {
        // Arrange
        int id = 1;
        Enseignant enseignant = new Enseignant(id, "John Doe", "john.doe@example.com", "Mathematics");
        when(enseignantRepository.findById(id)).thenReturn(Optional.of(enseignant));

        // Act
        enseignantService.deleteEnseignant(id);

        // Assert
        verify(enseignantRepository, times(1)).findById(id);
        verify(enseignantRepository, times(1)).delete(enseignant);
    }

    @Test
    void testDeleteEnseignant_NotFound() {
        // Arrange
        int id = 1;
        when(enseignantRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> enseignantService.deleteEnseignant(id));
        verify(enseignantRepository, times(1)).findById(id);
    }
}
