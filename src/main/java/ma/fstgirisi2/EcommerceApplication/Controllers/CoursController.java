package ma.fstgirisi2.EcommerceApplication.Controllers;

import ma.fstgirisi2.EcommerceApplication.Entities.Cours;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Services.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping("/getAllCours")
    public List<Cours> getAllCours() {
        // Example: GET http://localhost:8080/cours/getAllCours
        return coursService.getAllCours();
    }

    @GetMapping("/getCoursById/{id}")
    public Cours getCoursById(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: GET http://localhost:8080/cours/getCoursById/{id}
        return coursService.getCoursById(id);
    }

    @PostMapping(value = "/createCours", consumes = "application/json", produces = "application/json")
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.createCours(cours);
    }


    @PutMapping("/updateCours/{id}")
    public Cours updateCours(@PathVariable int id, @RequestBody Cours cours) throws ResourceNotFoundException {
        // Example link: PUT http://localhost:8080/cours/updateCours/{id}
        return coursService.updateCours(id, cours);
    }

    @DeleteMapping("/deleteCours/{id}")
    public void deleteCours(@PathVariable int id) throws ResourceNotFoundException {
        // Example link: DELETE http://localhost:8080/cours/deleteCours/{id}
        coursService.deleteCours(id);
    }
}
