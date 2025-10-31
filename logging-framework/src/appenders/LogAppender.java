package appenders;

import models.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
