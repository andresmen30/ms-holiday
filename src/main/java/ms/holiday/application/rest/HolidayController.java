package ms.holiday.application.rest;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.holiday.domain.model.Holiday;
import ms.holiday.domain.service.HolidayService;

@Slf4j
@Tag(name = "Holiday", description = "get holidays")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${rest.request.mapping}")
public class HolidayController {

   private final HolidayService holidayService;

   @GetMapping(value = "${rest.endpoint.holiday}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
   @ResponseStatus(HttpStatus.OK)
   @Operation(summary = "get holidays filter", description = "return holidays filtered by type, from and to date")
   public List<Holiday> getHolidays(@Parameter(description = "type holiday (optional)") @RequestParam(required = false) String type,
         @Parameter(description = "from date (format yyyy-MM-dd, optional)") @RequestParam(required = false) @DateTimeFormat(iso =
               DateTimeFormat.ISO.DATE) LocalDate from,
         @Parameter(description = "to date (format yyyy-MM-dd, optional)") @RequestParam(required = false) @DateTimeFormat(iso =
               DateTimeFormat.ISO.DATE) LocalDate to) {
      log.info("HolidayController.getHolidays({}, {}, {})", type, from, to);
      return holidayService.getHolidaysFilter(type, from, to);
   }

}
