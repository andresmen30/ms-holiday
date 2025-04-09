package ms.holiday.infraestructure.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import ms.holiday.infraestructure.exception.dto.ResponseDto;

@Slf4j
public class ResponseUtil {

   private final static ObjectMapper objectMapper = new ObjectMapper();

   public static ResponseDto response(final HttpStatus httpStatus, final Object data) {
      return ResponseDto.builder().message(httpStatus.name()).data(data).time(LocalDateTime.now()).build();
   }

   public static String objectToJsonString(final Object object) {
      try {
         return objectMapper.writeValueAsString(object);
      } catch (JsonProcessingException e) {
         log.error(e.getMessage(), e);
      }
      return "";
   }

}
