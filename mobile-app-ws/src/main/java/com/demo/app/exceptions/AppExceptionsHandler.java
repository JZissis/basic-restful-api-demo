package com.demo.app.exceptions;

import com.demo.app.ui.model.response.CustomErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        return createResponseEntity(ex);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        return createResponseEntity(ex);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        return createResponseEntity(ex);
    }

    private ResponseEntity<Object> createResponseEntity(Exception ex) {
        String customErrorMessageDescription = ex.getLocalizedMessage();
        if (customErrorMessageDescription == null)
            customErrorMessageDescription = ex.toString();

        CustomErrorMessage customErrorMessage = new CustomErrorMessage(new Date(), customErrorMessageDescription);

        return new ResponseEntity<>(customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
