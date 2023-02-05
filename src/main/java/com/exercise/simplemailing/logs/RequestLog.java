package com.exercise.simplemailing.logs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLog {

    public static void createNewLog(FileWriter fileWriter, String log) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        LocalDateTime now = LocalDateTime.now();
        bufferedWriter.write("/n"+now+ " "+log);
        bufferedWriter.close();

    }

    public static FileWriter createRequestFileWriter() throws IOException {
        return new FileWriter("requestLog.txt");
    }
}
