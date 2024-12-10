package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Departement;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(int id) throws ResourceNotFoundException {
        return departementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Département non trouvé avec l'ID : " + id));
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(int id, Departement departement) throws ResourceNotFoundException {
        Departement existingDepartement = getDepartementById(id);
        existingDepartement.setNomDepartement(departement.getNomDepartement());
        return departementRepository.save(existingDepartement);
    }

    public void deleteDepartement(int id) throws ResourceNotFoundException {
        Departement departement = getDepartementById(id);
        departementRepository.delete(departement);
    }
}

