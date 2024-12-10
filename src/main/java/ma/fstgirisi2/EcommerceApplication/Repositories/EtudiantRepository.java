package ma.fstgirisi2.EcommerceApplication.Repositories;

import ma.fstgirisi2.EcommerceApplication.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
