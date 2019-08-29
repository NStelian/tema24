package ro.itschool.tema24.repository.service;

import org.springframework.stereotype.Service;
import ro.itschool.tema24.repository.model.Markup;

import java.util.List;
import java.util.ArrayList;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Service
public class MarkupService {
    private final List<Markup> markups = new ArrayList<>();

    public List<Markup> getMarkups(String documentId) {
        return ofNullable(documentId)
                .map(this::getByDocumentId)
                .orElse(markups);
    }

    private List<Markup> getByDocumentId(String documentId) {
        return markups.stream()
                .filter(markup -> markup.getDocumentId().equals(documentId))
                .collect(toList());
    }

    public Markup addMarkup(String documentId, Markup markup) {
        markup.setDocumentId(documentId);
        markups.add(markup);
        return markup;
    }

    public Markup getMarkupById(String documentId, String markupId) {
        return getMarkups(documentId).stream()
                .filter(markup -> markup.getMarkupId().equals(markupId))
                .findFirst()
                .orElse(null);
    }

    public Markup updateMarkup(String documentId, String markupId, Markup markup) {
        final Markup existingMarkup = getMarkupById(documentId, markupId);
        if (existingMarkup != null) {
            markups.remove(existingMarkup);
            markups.add(markup);
            return existingMarkup;
        } else {
            return null;
        }
    }

    public Markup deleteMarkup(String documentId, String markupId) {
        final Markup markup = getMarkupById(documentId, markupId);
        if (markups.remove(markup)) {
            return markup;
        } else {
            return null;
        }
    }
}
