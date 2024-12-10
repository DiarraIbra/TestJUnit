package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Cours;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {
    @Autowired
    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Cours getCoursById(int id) throws ResourceNotFoundException {
        return coursRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cours non trouvé avec l'ID : " + id));
    }

    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public Cours updateCours(int id, Cours cours) throws ResourceNotFoundException {
        Cours existingCours = getCoursById(id);
        existingCours.setNomCours(cours.getNomCours());
        existingCours.setCredits(cours.getCredits());
        return coursRepository.save(existingCours);
    }

    public void deleteCours(int id) throws ResourceNotFoundException {
        Cours cours = getCoursById(id);
        coursRepository.delete(cours);
    }
}

