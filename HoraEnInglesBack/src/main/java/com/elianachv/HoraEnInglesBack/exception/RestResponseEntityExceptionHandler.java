package com.elianachv.HoraEnInglesBack.exception;

import com.elianachv.HoraEnInglesBack.model.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<RespuestaError> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        String error = "El archivo no cumple con el formato requerido";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(crearREspuestaError(error));
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    protected ResponseEntity<RespuestaError> handleNNumberFormatException(NumberFormatException ex, WebRequest request) {
        String error = "El archivo no cumple con el formato requerido";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(crearREspuestaError(error));
    }

    @ExceptionHandler(value = {IOException.class})
    protected ResponseEntity<RespuestaError> handleIOException(IOException ex, WebRequest request) {
        String error = "No fue posible cargar el archivo";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(crearREspuestaError(error));
    }

    @ExceptionHandler(value = {TipoDeArchivoIncorrectoException.class})
    protected ResponseEntity<RespuestaError> handleTipoDeArchivoIncorrectoException(TipoDeArchivoIncorrectoException ex, WebRequest request) {
        String error = "El tipo de archivo no es el correcto";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(crearREspuestaError(error));
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<RespuestaError> handleGenericException(Exception ex, WebRequest request) {
        String error = "Error inesperado. Intenta más tarde o contacta soporte";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(crearREspuestaError(error));
    }

    private RespuestaError crearREspuestaError(String mensaje) {
        RespuestaError error = new RespuestaError();
        error.setDescripcion(mensaje);
        return error;

    }
}