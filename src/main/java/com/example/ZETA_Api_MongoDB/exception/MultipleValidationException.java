package com.example.ZETA_Api_MongoDB.exception;

import java.util.Map;

public class MultipleValidationException extends RuntimeException {
  private final Map<String, String> errors;

  public MultipleValidationException(Map<String, String> errors) {
    super("Erros de validação");
    this.errors = errors;
  }

  public Map<String, String> getErrors() {
    return errors;
  }
}