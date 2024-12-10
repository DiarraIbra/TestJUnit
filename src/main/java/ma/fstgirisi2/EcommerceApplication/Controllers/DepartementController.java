package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Departement;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.DepartementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("/getAllDepartements")
    public List<Departement> getAllDepartements() {
        // Example link: GET http://localhost:8080/departements/getAllDepartements
        return departementService.getAllDepartements();
    }

    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementById(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: GET http://localhost:8080/departements/getDepartementById/{id}
        return departementService.getDepartementById(id);
    }

    @PostMapping("/createDepartement")
    public Departement createDepartement(@RequestBody Departement departement) {
        // Example link: POST http://localhost:8080/departements/createDepartement
        return departementService.createDepartement(departement);
    }

    @PutMapping("/updateDepartement/{id}")
    public Departement updateDepartement(@PathVariable int id, @RequestBody Departement departement) throws ResourceNotFoundException {
        // Example link: PUT http://localhost:8080/departements/updateDepartement/{id}
        return departementService.updateDepartement(id, departement);
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public void deleteDepartement(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: DELETE http://localhost:8080/departements/deleteDepartement/{id}
        departementService.deleteDepartement(id);
    }
}
