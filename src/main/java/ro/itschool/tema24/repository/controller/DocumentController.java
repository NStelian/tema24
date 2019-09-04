package ro.itschool.tema24.repository.controller;

import org.springframework.web.bind.annotation.*;
import ro.itschool.tema24.repository.model.Document;
import ro.itschool.tema24.repository.service.DocumentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    @PostMapping
    Document addDocument(@RequestBody Document document) {
        return documentService.addDocument(document);
    }

    @GetMapping("{documentId}")
    Optional<Document> getDocumentById(@PathVariable Integer documentId) {
        return documentService.getDocumentById(documentId);
    }

    @PutMapping("{documentId}")
    Optional<Document> updateDocument(@PathVariable Integer documentId, @RequestBody Document document) {
        return documentService.updateDocument(documentId, document);
    }

    @DeleteMapping("{documentId}")
    void deleteDocument(@PathVariable Integer documentId) {
        documentService.deleteDocument(documentId);
    }
}
