package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Enseignant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.EnseignantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/getAllEnseignants")
    public List<Enseignant> getAllEnseignants() {
        // Example link: GET http://localhost:8080/enseignants/getAllEnseignants
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/getEnseignantById/{id}")
    public Enseignant getEnseignantById(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: GET http://localhost:8080/enseignants/getEnseignantById/{id}
        return enseignantService.getEnseignantById(id);
    }

    @PostMapping("/createEnseignant")
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        // Example link: POST http://localhost:8080/enseignants/createEnseignant
        return enseignantService.createEnseignant(enseignant);
    }

    @PutMapping("/updateEnseignant/{id}")
    public Enseignant updateEnseignant(@PathVariable int id, @RequestBody Enseignant enseignant) throws ResourceNotFoundException {
        // Example link: PUT http://localhost:8080/enseignants/updateEnseignant/{id}
        return enseignantService.updateEnseignant(id, enseignant);
    }

    @DeleteMapping("/deleteEnseignant/{id}")
    public void deleteEnseignant(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: DELETE http://localhost:8080/enseignants/deleteEnseignant/{id}
        enseignantService.deleteEnseignant(id);
    }
}
