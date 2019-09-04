package ro.itschool.tema24.repository.service;

import org.springframework.stereotype.Service;
import ro.itschool.tema24.repository.DocumentRepository;
import ro.itschool.tema24.repository.model.Document;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

//    private List<Document> getByName(String name) {
//        return documents.stream()
//                .filter(document -> document.getName().equals(name))
//                .collect(toList());
//    }

    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    public Optional<Document> getDocumentById(Integer documentId) {
        return documentRepository.findById(documentId);
    }

    public Optional<Document> updateDocument(Integer documentId, Document document) {
        final Optional<Document> existingDocument = getDocumentById(documentId);
        if (existingDocument.isPresent()) {
            documentRepository.deleteById(documentId);
            document.setDocumentId(documentId);
            documentRepository.save(document);
        }
        return existingDocument;
    }

    public void deleteDocument(Integer documentId) {
        documentRepository.deleteById(documentId);
    }
}
