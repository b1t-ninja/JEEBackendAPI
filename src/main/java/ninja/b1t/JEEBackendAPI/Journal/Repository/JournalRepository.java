package ninja.b1t.JEEBackendAPI.Journal.Repository;

import ninja.b1t.JEEBackendAPI.Journal.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
}
