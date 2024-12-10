package ma.fstgirisi2.EcommerceApplication.Repositories;

import ma.fstgirisi2.EcommerceApplication.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}
