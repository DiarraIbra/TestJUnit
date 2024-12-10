package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Enseignant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnseignantService extends PersonneService {
    @Autowired
    private final EnseignantRepository enseignantRepository;

    public EnseignantService(EnseignantRepository enseignantRepository) {
        super(enseignantRepository);
        this.enseignantRepository = enseignantRepository;
    }

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(int id) throws ResourceNotFoundException {
        return enseignantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enseignant non trouvé avec l'ID : " + id));
    }

    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public Enseignant updateEnseignant(int id, Enseignant enseignant) throws ResourceNotFoundException {
        Enseignant existingEnseignant = getEnseignantById(id);
        existingEnseignant.setMatiere(enseignant.getMatiere());
        existingEnseignant.setNom(enseignant.getNom());
        existingEnseignant.setEmail(enseignant.getEmail());
        return enseignantRepository.save(existingEnseignant);
    }

    public void deleteEnseignant(int id) throws ResourceNotFoundException {
        Enseignant enseignant = getEnseignantById(id);
        enseignantRepository.delete(enseignant);
    }
}
