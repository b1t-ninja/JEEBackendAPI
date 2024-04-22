package ninja.b1t.JEEBackendAPI.Journal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class JournalEntry {
    private @Id
    @GeneratedValue long id;
    private String content;
    private Date created;
    private Mood mood;

    public JournalEntry() {
    }

    public JournalEntry(String content, Date created, Mood mood) {
        this.content = content;
        this.created = created;
        this.mood = mood;
    }
}
