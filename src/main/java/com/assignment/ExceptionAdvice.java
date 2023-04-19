package com.assignment;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.constant.Errors;
import com.assignment.dto.ExceptionResponse;
import com.assignment.exception.AuthorizedException;
import com.assignment.exception.BindingException;
import com.assignment.exception.CommonException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice implements ErrorController {

    @ExceptionHandler(AuthorizedException.class)
    public ResponseEntity<ExceptionResponse> auth(HttpServletRequest request, AuthorizedException e) {

        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setTitle("에러");
        response.setMessage(e.getMessage());

        request.setAttribute("warn", e);
        request.setAttribute("warn-response", response);

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = BindingException.class)
    public ResponseEntity<ExceptionResponse> bindingException(HttpServletRequest request, BindingException e) {
        FieldError fe = e.getFieldError();

        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTitle("에러");
        response.setMessage("'" + fe.getField() + "' " + fe.getDefaultMessage());

        request.setAttribute("warn", e);
        request.setAttribute("warn-response", response);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ExceptionResponse> commonException(HttpServletRequest request, CommonException e) {

        ExceptionResponse response = new ExceptionResponse(e.getError());
        response.setStatus(e.getError().getCode());
        response.setTitle(e.getError().getTitle());
        response.setMessage(e.getMessage());

        request.setAttribute("warn", e);
        request.setAttribute("warn-response", response);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(HttpServletRequest request, Exception e) {

        ExceptionResponse response = new ExceptionResponse(Errors.GENERAL_UNKNOWN);
        response.setStatus(Errors.GENERAL_UNKNOWN.getCode());
        response.setTitle(Errors.GENERAL_UNKNOWN.getTitle());
        response.setMessage(Errors.GENERAL_UNKNOWN.getMessage());
        log.error("exception : {}", e.getMessage(), e);

        request.setAttribute("warn", e);
        request.setAttribute("warn-response", response);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
