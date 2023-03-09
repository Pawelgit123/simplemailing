package com.exercise.simplemailing.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerReq {

    Logger logger = LoggerFactory.getLogger(LoggerReq.class);

    public void makeLog(String message){

        logger.info(message);

    }
}
