package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Enseignant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.EnseignantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnseignantControllerTest {

    @Mock
    private EnseignantService enseignantService;

    @InjectMocks
    private EnseignantController enseignantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }





    @Test
    void getEnseignantById_ShouldThrowException_WhenIdDoesNotExist() throws ResourceNotFoundException {
        // Arrange
        when(enseignantService.getEnseignantById(99)).thenThrow(new ResourceNotFoundException("Enseignant not found"));

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> enseignantController.getEnseignantById(99));
        verify(enseignantService, times(1)).getEnseignantById(99);
    }





    @Test
    void deleteEnseignant_ShouldCallServiceDelete_WhenIdExists() throws ResourceNotFoundException {
        // Act
        enseignantController.deleteEnseignant(1);

        // Assert
        verify(enseignantService, times(1)).deleteEnseignant(1);
    }

    @Test
    void deleteEnseignant_ShouldThrowException_WhenIdDoesNotExist() throws ResourceNotFoundException {
        // Arrange
        doThrow(new ResourceNotFoundException("Enseignant not found")).when(enseignantService).deleteEnseignant(99);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> enseignantController.deleteEnseignant(99));
        verify(enseignantService, times(1)).deleteEnseignant(99);
    }
}
