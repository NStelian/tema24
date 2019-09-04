package ro.itschool.tema24;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.tema24.repository.DocumentRepository;
import ro.itschool.tema24.repository.model.Document;

import java.util.List;

@SpringBootApplication
public class Tema24Application {

    public static void main(String[] args) {
        SpringApplication.run(Tema24Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(DocumentRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new Document("doc1", "content1", "owner1"),
                    new Document("doc2", "content2", "owner2"),
                    new Document("doc3", "content3", "owner3"),
                    new Document("doc4", "content4", "owner4"),
                    new Document("doc5", "content5", "owner5")
            ));
        };
    }
}
