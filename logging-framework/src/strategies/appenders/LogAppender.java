package strategies.appenders;

import models.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
