package ma.fstgirisi2.EcommerceApplication.Repositories;

import ma.fstgirisi2.EcommerceApplication.Entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
