package ms.holiday.infraestructure.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;
import ms.holiday.infraestructure.exception.dto.ResponseDto;

@Slf4j
public class ResponseUtil {

   public static ResponseDto response(final HttpStatus httpStatus, final Object data) {
      return ResponseDto.builder().message(httpStatus.name()).data(data).time(LocalDateTime.now()).build();
   }

}
