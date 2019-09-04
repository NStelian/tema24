package ro.itschool.tema24.repository.service;

import org.springframework.stereotype.Service;
import ro.itschool.tema24.repository.MarkupRepository;
import ro.itschool.tema24.repository.model.Markup;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class MarkupService {
    private final MarkupRepository markupRepository;

    public MarkupService(MarkupRepository markupRepository) {
        this.markupRepository = markupRepository;
    }

    public List<Markup> getMarkups(Integer documentId) {
        return markupRepository.findByDocumentId(documentId);
    }

    public Markup addMarkup(Integer documentId, Markup markup) {
        markup.setDocumentId(documentId);
        markupRepository.save(markup);
        return markup;
    }

    public Markup getMarkupById(Integer documentId, String markupId) {
        return getMarkups(documentId).stream()
                .filter(markup -> markup.getMarkupId().equals(markupId))
                .findFirst()
                .orElse(null);
    }

//    public Markup updateMarkup(String documentId, String markupId, Markup markup) {
//        final Markup existingMarkup = getMarkupById(documentId, markupId);
//        if (existingMarkup != null) {
//            markups.remove(existingMarkup);
//            markups.add(markup);
//            return existingMarkup;
//        } else {
//            return null;
//        }
//    }

    public void deleteMarkup(Integer documentId, String markupId) {
        markupRepository.delete(getMarkupById(documentId,markupId));
    }
}
