package com.maximvolk.regions_directory.web;

import com.maximvolk.regions_directory.core.exceptions.BadRequestException;
import com.maximvolk.regions_directory.core.exceptions.NotFoundException;
import com.maximvolk.regions_directory.web.controllers.RegionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(CustomResponseEntityExceptionHandler.class);

    public CustomResponseEntityExceptionHandler() {
        super();
    }

    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<Object> handleBadRequest(final BadRequestException ex, final WebRequest request) {
        logger.info("Domain exception caught, returning Bad Request");
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFound(final NotFoundException ex, final WebRequest request) {
        logger.info("Domain exception caught, returning Not Found");
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleInternal(final Exception ex, final WebRequest request) {
        logger.error("Something went wrong, returning Internal Server Error. Trace: " + ex.getMessage());
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
