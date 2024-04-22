package ninja.b1t.JEEBackendAPI.Journal.Controller;

import ninja.b1t.JEEBackendAPI.Excenptions.JournalEntryNotFoundException;
import ninja.b1t.JEEBackendAPI.Journal.Entity.JournalEntry;
import ninja.b1t.JEEBackendAPI.Journal.Repository.JournalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {
    private final JournalRepository repository;

    JournalController(JournalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/journalentries")
    List<JournalEntry> all() {
        return repository.findAll();
    }

    @PostMapping("/journalentries")
    JournalEntry newJournalEntry(@RequestBody JournalEntry entry) {
        return repository.save(entry);
    }

    @GetMapping("/journalentries/{id}")
    JournalEntry one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new JournalEntryNotFoundException(id));
    }

    @PutMapping("/journalentries/{id}")
    JournalEntry replaceJournalEntry(@PathVariable Long id, @RequestBody JournalEntry newEntry) {
        return repository.findById(id)
                .map(entry -> {
                    entry.setContent(newEntry.getContent());
                    entry.setCreated(newEntry.getCreated());
                    entry.setMood(newEntry.getMood());
                    return repository.save(entry);
                })
                .orElseGet(() -> {
                    newEntry.setId(id);
                    return repository.save(newEntry);
                });
    }

    @DeleteMapping("/journalentries/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
