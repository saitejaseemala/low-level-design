package strategies.appenders;

import lombok.RequiredArgsConstructor;
import models.LogMessage;
import strategies.formatters.LogFormatter;

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
