package appenders;

import formatters.LogFormatter;
import lombok.RequiredArgsConstructor;
import models.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RequiredArgsConstructor
public class FileAppender implements LogAppender {

    private final LogFormatter formatter;
    private final BufferedWriter writer;

    public FileAppender(LogFormatter logFormatter, String fileName) {
        this.formatter = logFormatter;
        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void append(LogMessage logMessage) {
        try {
            writer.write(formatter.format(logMessage));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
