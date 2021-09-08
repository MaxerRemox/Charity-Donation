package pl.coderslab.charity.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;

@Repository
public interface InstitutionRepo extends JpaRepository<Institution, Long> {
}
