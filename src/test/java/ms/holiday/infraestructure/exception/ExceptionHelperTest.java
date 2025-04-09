package ms.holiday.infraestructure.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import ms.holiday.infraestructure.exception.dto.ResponseDto;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ExceptionHelperTest {

   @InjectMocks
   private ExceptionHelper exceptionHelper;

   @Mock
   private BindingResult bindingResult;

   @Mock
   private ConstraintViolation<?> constraintViolation;

   @Mock
   private Path propertyPath;

   @Mock
   private MethodArgumentTypeMismatchException methodArgumentTypeMismatchException;

   @Test
   void handleMethodArgumentNotValid() {
      final FieldError fieldError = new FieldError("objectName", "fieldName", "must not be empty");
      when(bindingResult.getAllErrors()).thenReturn(Collections.singletonList(fieldError));
      final MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);
      final ResponseDto response = exceptionHelper.handleMethodArgumentNotValid(exception);
      assertNotNull(response);
      assertNotNull(response.getData());
      assertNotNull(response.getTime());
      assertNotNull(response.getMessage());
   }

   @Test
   void handleConstraintViolationException() {
      when(propertyPath.toString()).thenReturn("campoPrueba");
      when(constraintViolation.getPropertyPath()).thenReturn(propertyPath);
      Set<ConstraintViolation<?>> violations = Collections.singleton(constraintViolation);
      ConstraintViolationException exception = new ConstraintViolationException(violations);
      ResponseDto response = exceptionHelper.handleConstraintViolationException(exception);
      assertNotNull(response);
      assertNotNull(response.getData());
      assertNotNull(response.getTime());
      assertNotNull(response.getMessage());
   }

   @Test
   void handleMethodArgumentTypeMismatch() {
      when(methodArgumentTypeMismatchException.getMessage()).thenReturn("Tipo de argumento inválido");
      final ResponseDto response = exceptionHelper.handleMethodArgumentTypeMismatch(methodArgumentTypeMismatchException);
      assertNotNull(response);
      assertNotNull(response);
      assertNotNull(response.getData());
      assertNotNull(response.getTime());
      assertNotNull(response.getMessage());
   }

   @Test
   void testHandleException() {
      final Exception exception = new Exception("Error interno del servidor");
      final ResponseDto response = exceptionHelper.handleException(exception);
      assertNotNull(response);
      assertNotNull(response.getData());
      assertNotNull(response.getTime());
      assertNotNull(response.getMessage());
   }

}