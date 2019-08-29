package ro.itschool.tema24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.tema24.repository.model.Document;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
}
