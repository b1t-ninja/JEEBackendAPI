package ninja.b1t.JEEBackendAPI.Excenptions;

public class JournalEntryNotFoundException extends RuntimeException {
    public JournalEntryNotFoundException(long id) {
        super("Could not find Journal Entry " + id);
    }
}
