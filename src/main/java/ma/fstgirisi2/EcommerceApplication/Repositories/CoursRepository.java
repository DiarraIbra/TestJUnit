package ma.fstgirisi2.EcommerceApplication.Repositories;

import ma.fstgirisi2.EcommerceApplication.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> {
}