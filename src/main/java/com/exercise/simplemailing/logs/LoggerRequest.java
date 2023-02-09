package com.exercise.simplemailing.logs;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Data
public class LoggerRequest {

    public void createNewLog(BufferedWriter bufferedWriter,String log) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        bufferedWriter.write(now.withNano(0)+ " "+log);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

}
