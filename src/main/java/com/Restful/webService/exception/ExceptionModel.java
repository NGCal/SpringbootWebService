package com.Restful.webService.exception;

import java.util.Date;

public class ExceptionModel {
    private String message;
    private String path;
    private Date timestamp;

    public ExceptionModel(String message, String path, Date timestamp) {
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
