package formatters;

import models.LogMessage;

import java.time.format.DateTimeFormatter;

public class TextFormatter implements LogFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s [%s] - %s", logMessage.getTimeStamp().format(DATE_TIME_FORMATTER), logMessage.getLevel(), logMessage.getMessage());
    }

}
