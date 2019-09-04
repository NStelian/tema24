package ro.itschool.tema24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.tema24.repository.model.Markup;

import java.util.List;

public interface MarkupRepository extends JpaRepository<Markup,Integer> {
    List<Markup> findByDocumentId(Integer id);
}
