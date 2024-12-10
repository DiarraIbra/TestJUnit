package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Etudiant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("getById/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) throws ResourceNotFoundException {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping("/AjoutEtudiant")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) throws ResourceNotFoundException {
        return etudiantService.createEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiant) throws ResourceNotFoundException {
        return etudiantService.updateEtudiant(id, etudiant);
    }

    @DeleteMapping("deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable int id) throws ResourceNotFoundException {
        etudiantService.deleteEtudiant(id);
    }
}