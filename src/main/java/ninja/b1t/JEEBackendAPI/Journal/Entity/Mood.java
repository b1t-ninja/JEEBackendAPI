package ninja.b1t.JEEBackendAPI.Journal.Entity;

public enum Mood {
    VERY_GOOD,
    GOOD,
    MEDIUM,
    UNKNOWN,
    LOW;

    public String getMoodString() {
        return switch (this) {
            case VERY_GOOD -> "🐦‍🔥";
            case GOOD -> "🍦";
            case MEDIUM -> "🐟";
            case UNKNOWN -> "🤷🏾‍♂️";
            case LOW -> "🔺";
            default -> throw new IllegalStateException("Unexpected value: " + this.name());
        };
    }

    public int getNumericValue() {
        return switch (this) {
            case VERY_GOOD -> 10;
            case GOOD -> 8;
            case MEDIUM -> 6;
            case UNKNOWN -> 4;
            case LOW -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + this.name());
        };
    }
}