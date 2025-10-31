package appenders;

import models.LogMessage;
import formatters.LogFormatter;

public class ConsoleAppender implements LogAppender {

    private final LogFormatter logFormatter;

    public ConsoleAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logFormatter.format(logMessage));
    }
}
