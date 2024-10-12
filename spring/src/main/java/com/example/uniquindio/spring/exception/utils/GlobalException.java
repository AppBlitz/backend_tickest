package com.example.uniquindio.spring.exception.utils;

import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.MensajeDto;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.ValidationDto;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class GlobalException {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<MensajeDto<String>> generalException(Exception e){
    return ResponseEntity.internalServerError().body( new MensajeDto<>(true, e.getMessage()) );
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<MensajeDto<List<ValidationDto>>> validationException( MethodArgumentNotValidException ex ) {
    List<ValidationDto> errores = new ArrayList<>();
    BindingResult results = ex.getBindingResult();


    for (FieldError e: results.getFieldErrors()) {
      errores.add( new ValidationDto(e.getField(), e.getDefaultMessage()) );
    }


    return ResponseEntity.badRequest().body( new MensajeDto<>(true, errores) );
  }


}

