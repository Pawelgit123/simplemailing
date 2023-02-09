package com.exercise.simplemailing.logs;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoggerAll {

    Logger logger = LoggerFactory.getLogger(LoggerAll.class);

    public void makeLog(String message){

        logger.info(message);

    }
}
