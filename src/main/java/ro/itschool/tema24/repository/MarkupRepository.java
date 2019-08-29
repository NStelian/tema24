package ro.itschool.tema24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.tema24.repository.model.Markup;

public interface MarkupRepository extends JpaRepository<Markup,Integer> {
}
