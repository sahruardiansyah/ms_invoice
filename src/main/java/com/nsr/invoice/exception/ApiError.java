package com.nsr.invoice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiError {
	private static Logger logger = LoggerFactory.getLogger(ApiError.class);

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<String > details;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        logger.error(ex.getLocalizedMessage());
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        logger.error(ex.getLocalizedMessage());
    }
    public ApiError(HttpStatus status,String message, List<String> details, Throwable ex) {
    	this();
    	this.status = status;
    	this.message =message;
    	this.details = details;
    	logger.error(ex.getLocalizedMessage());
    	
    }
    public ApiError(HttpStatus status, String message, List<String> details) {
        this();
        this.status = status;
        this.message = message;
        this.details = details;

    }

}
