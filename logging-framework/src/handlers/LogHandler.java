package handlers;

import enums.LogLevel;
import lombok.Setter;
import models.LogMessage;
import appenders.LogAppender;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {

    private final List<LogAppender> appenders = new CopyOnWriteArrayList<>();

    @Setter
    private LogHandler next;

    public void subscribe(LogAppender observer) {
        appenders.add(observer);
    }

    public void notifyObservers(LogMessage logMessage) {
        for (LogAppender appender : appenders) {
            appender.append(logMessage);
        }
    }

    public void handle(LogMessage logMessage) {
        if (canHandle(logMessage.getLevel())) {
            notifyObservers(logMessage);
        } else if (next != null) {
            next.handle(logMessage);
        }
    }

    abstract boolean canHandle(LogLevel logLevel);
}
