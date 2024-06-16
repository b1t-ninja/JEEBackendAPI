package ninja.b1t.JEEBackendAPI.Journal.Entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Mood {
    VERY_GOOD,
    GOOD,
    MEDIUM,
    UNKNOWN,
    LOW;

    @JsonValue
    public String getMoodString() {
        return switch (this) {
            case VERY_GOOD -> "gauge.with.dots.needle.100percent";
            case GOOD -> "gauge.with.dots.needle.67percent";
            case MEDIUM -> "gauge.with.dots.needle.50percent";
            case UNKNOWN -> "questionmark.circle";
            case LOW -> "gauge.with.dots.needle.0percent";
            default -> throw new IllegalStateException("Unexpected value: " + this.name());
        };
    }

    public int getNumericValue() {
        return switch (this) {
            case VERY_GOOD -> 8;
            case GOOD -> 6;
            case MEDIUM -> 4;
            case UNKNOWN -> 2;
            case LOW -> 0;
            default -> throw new IllegalStateException("Unexpected value: " + this.name());
        };
    }
}