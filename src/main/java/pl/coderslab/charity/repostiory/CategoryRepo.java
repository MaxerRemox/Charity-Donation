package pl.coderslab.charity.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
