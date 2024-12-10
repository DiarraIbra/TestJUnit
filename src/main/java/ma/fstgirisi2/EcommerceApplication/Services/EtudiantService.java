package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Etudiant;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
 
    public Etudiant getEtudiantById(int id) throws ResourceNotFoundException {
        return etudiantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Étudiant non trouvé avec l'ID : " + id));
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(int id, Etudiant etudiant) throws ResourceNotFoundException {
        Etudiant existingEtudiant = getEtudiantById(id);
        existingEtudiant.setSpecialite(etudiant.getSpecialite());
        return etudiantRepository.save(existingEtudiant);
    }

    public void deleteEtudiant(int id) throws ResourceNotFoundException {
        Etudiant etudiant = getEtudiantById(id);
        etudiantRepository.delete(etudiant);
    }
}

