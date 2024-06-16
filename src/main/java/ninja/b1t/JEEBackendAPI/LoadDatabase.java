package ninja.b1t.JEEBackendAPI;

import ninja.b1t.JEEBackendAPI.Journal.Entity.JournalEntry;
import ninja.b1t.JEEBackendAPI.Journal.Entity.Mood;
import ninja.b1t.JEEBackendAPI.Journal.Repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.Date;

// Initialises DB with data; in production, we won't need this
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(JournalRepository repository) {

        return args -> {
            log.info("Preloading {}", repository.save(new JournalEntry("Today was a very nice day, I am happy I experience it", ZonedDateTime.now(), Mood.GOOD)));
            log.info("Preloading {}", repository.save(new JournalEntry("I got a new Dog today, feeling over the moon", ZonedDateTime.now(), Mood.VERY_GOOD)));
        };
    }
}
