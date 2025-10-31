package formatters;

import models.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
