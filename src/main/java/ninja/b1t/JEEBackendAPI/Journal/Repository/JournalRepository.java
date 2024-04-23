package ninja.b1t.JEEBackendAPI.Journal.Repository;

import ninja.b1t.JEEBackendAPI.Journal.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

// here we need a connection to the DB 🗑️
public interface JournalRepository extends JpaRepository<JournalEntry, Long> {}
