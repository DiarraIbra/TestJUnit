package ma.fstgirisi2.EcommerceApplication.Repositories;

import ma.fstgirisi2.EcommerceApplication.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
}