package com.bridgelabz.bookstorebackend.exception;

import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class JwtExceptionHandler {

    private static final String message = "Exception while processing REST request";

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleJwtException(UsernameNotFoundException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
