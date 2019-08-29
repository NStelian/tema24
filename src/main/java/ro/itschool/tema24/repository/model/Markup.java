package ro.itschool.tema24.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "MARKUPS")
public class Markup {
    @Id
    @GeneratedValue
    private String markupId;
    private String documentId;
    private String content;
    private int position;

    public Markup(String documentId, String content, int position) {
        this.documentId = documentId;
        this.content = content;
        this.position = position;
    }

    public String getMarkupId() {
        return markupId;
    }

    public void setMarkupId(String markupId) {
        this.markupId = markupId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Markup markup = (Markup) o;
        return position == markup.position &&
                Objects.equals(markupId, markup.markupId) &&
                Objects.equals(documentId, markup.documentId) &&
                Objects.equals(content, markup.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markupId, documentId, content, position);
    }

    @Override
    public String toString() {
        return "Markup{" +
                "markupId='" + markupId + '\'' +
                ", documentId='" + documentId + '\'' +
                ", content='" + content + '\'' +
                ", position=" + position +
                '}';
    }
}
