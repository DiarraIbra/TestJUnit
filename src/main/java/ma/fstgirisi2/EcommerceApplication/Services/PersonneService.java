package ma.fstgirisi2.EcommerceApplication.Services;

import ma.fstgirisi2.EcommerceApplication.Entities.Personne;
import ma.fstgirisi2.EcommerceApplication.Exceptions.ResourceNotFoundException;
import ma.fstgirisi2.EcommerceApplication.Repositories.EnseignantRepository;
import ma.fstgirisi2.EcommerceApplication.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    private  PersonneRepository personneRepository;

    public PersonneService(EnseignantRepository enseignantRepository) {
    }


    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public Personne getPersonneById(int id) throws ResourceNotFoundException {
        return personneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personne non trouvée avec l'ID : " + id));
    }

    public Personne createPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public Personne updatePersonne(int id, Personne personne) throws ResourceNotFoundException {
        Personne existingPersonne = getPersonneById(id);
        existingPersonne.setNom(personne.getNom());
        existingPersonne.setEmail(personne.getEmail());
        return personneRepository.save(existingPersonne);
    }

    public void deletePersonne(int id) throws ResourceNotFoundException {
        Personne personne = getPersonneById(id);
        personneRepository.delete(personne);
    }
}

