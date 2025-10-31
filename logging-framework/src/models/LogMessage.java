package models;

import enums.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


public class LogMessage {


    private final LogLevel level;
    private final String message;
    private final LocalDateTime timeStamp;

    public LogMessage(LogLevel level, String message, LocalDateTime timeStamp) {
        this.level = level;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
