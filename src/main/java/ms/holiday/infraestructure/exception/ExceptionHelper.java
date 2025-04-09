package ms.holiday.infraestructure.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.naming.AuthenticationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;
import ms.holiday.infraestructure.exception.dto.ResponseDto;
import ms.holiday.infraestructure.util.ResponseUtil;

@ControllerAdvice
public class ExceptionHelper {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   protected @ResponseBody ResponseDto handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
      final List<String> details = new ArrayList<>();
      ex.getBindingResult().getAllErrors().forEach(error -> {
         final String detail = StringUtils.join(((FieldError) error).getField(), " : ", Objects.requireNonNull(error.getDefaultMessage()));
         details.add(detail);
      });
      return ResponseUtil.response(HttpStatus.BAD_REQUEST, details.toString());
   }

   @ExceptionHandler(ConstraintViolationException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   protected @ResponseBody ResponseDto handleConstraintViolationException(final ConstraintViolationException ex) {
      final List<String> details = new ArrayList<>();
      ex.getConstraintViolations().forEach(constraintViolation -> {
         final String detail = StringUtils.join(constraintViolation.getPropertyPath(), " : ", constraintViolation.getMessage());
         details.add(detail);
      });
      return ResponseUtil.response(HttpStatus.BAD_REQUEST, details.toString());
   }

   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   protected @ResponseBody ResponseDto handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex) {
      return ResponseUtil.response(HttpStatus.BAD_REQUEST, ex.getMessage());
   }

   @ExceptionHandler(MissingServletRequestParameterException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   protected @ResponseBody ResponseDto handleMissingServletRequestParameter(final MissingServletRequestParameterException ex) {
      return ResponseUtil.response(HttpStatus.BAD_REQUEST, ex.getMessage());
   }

   @ExceptionHandler(SQLException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   protected @ResponseBody ResponseDto handleSqlException(final SQLException ex) {
      return ResponseUtil.response(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
   }

   @ExceptionHandler(HttpMessageNotReadableException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   protected @ResponseBody ResponseDto handleMessageReadable(final HttpMessageNotReadableException ex) {
      return ResponseUtil.response(HttpStatus.BAD_REQUEST, ex.getMessage());

   }

   @ExceptionHandler(AuthenticationException.class)
   @ResponseStatus(HttpStatus.UNAUTHORIZED)
   protected @ResponseBody ResponseDto handleException(final AuthenticationException ex) {
      return ResponseUtil.response(HttpStatus.UNAUTHORIZED, ex.getMessage());
   }

   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   protected @ResponseBody ResponseDto handleException(final Exception ex) {
      return ResponseUtil.response(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
   }

}
