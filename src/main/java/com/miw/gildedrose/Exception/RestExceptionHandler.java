package com.miw.gildedrose.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	private class ExceptionJsonResponse {
        String message;

        public ExceptionJsonResponse() {
        }

        public ExceptionJsonResponse(String message) {
            super();
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }       
    }
	

    @ExceptionHandler(value = Exception.class)  
    public ResponseEntity<ExceptionJsonResponse> handleGeneralException(Exception e) {
        return new ResponseEntity<ExceptionJsonResponse>(new ExceptionJsonResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserDefinedSystemException.class)  
    public ResponseEntity<ExceptionJsonResponse> handleException(Exception e) {
        return new ResponseEntity<ExceptionJsonResponse>(new ExceptionJsonResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
