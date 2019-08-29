package ro.itschool.tema24.repository.controller;

import org.springframework.web.bind.annotation.*;
import ro.itschool.tema24.repository.model.Document;
import ro.itschool.tema24.repository.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    List<Document> getDocuments(@RequestParam(required = false) String name, @RequestParam(required = false) String owner) {
        return documentService.getDocuments(name, owner);
    }

    @PostMapping
    Document addDocument(@RequestBody Document document) {
        return documentService.addDocument(document);
    }

    @GetMapping("{documentId}")
    Document getDocumentById(@PathVariable String documentId) {
        return documentService.getDocumentById(documentId);
    }

    @PutMapping("{documentId}")
    Document updateDocument(@PathVariable String documentId, @RequestBody Document document) {
        return documentService.updateDocument(documentId, document);
    }

    @DeleteMapping("{documentId}")
    Document deleteDocument(@PathVariable String documentId) {
        return documentService.deleteDocument(documentId);
    }
}
