package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Personne;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/getAllPersonnes")
    public List<Personne> getAllPersonnes() {
        // Example link: GET http://localhost:8080/personnes/getAllPersonnes
        return personneService.getAllPersonnes();
    }

    @GetMapping("/getPersonneById/{id}")
    public Personne getPersonneById(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: GET http://localhost:8080/personnes/getPersonneById/{id}
        return personneService.getPersonneById(id);
    }

    @PostMapping("/createPersonne")
    public Personne createPersonne(@RequestBody Personne personne) {
        // Example link: POST http://localhost:8080/personnes/createPersonne
        return personneService.createPersonne(personne);
    }

    @PutMapping("/updatePersonne/{id}")
    public Personne updatePersonne(@PathVariable int id, @RequestBody Personne personne) throws ResourceNotFoundException {
        // Example link: PUT http://localhost:8080/personnes/updatePersonne/{id}
        return personneService.updatePersonne(id, personne);
    }

    @DeleteMapping("/deletePersonne/{id}")
    public void deletePersonne(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: DELETE http://localhost:8080/personnes/deletePersonne/{id}
        personneService.deletePersonne(id);
    }
}
