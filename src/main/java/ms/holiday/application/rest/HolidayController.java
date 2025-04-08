package ms.holiday.application.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ms.holiday.domain.model.Holiday;
import ms.holiday.domain.service.HolidayService;

//@Tag(name = "Candidate", description = "CRUD")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${rest.request.mapping}")
public class HolidayController {

   private final HolidayService holidayService;

   @GetMapping(value = "${rest.endpoint.holiday}")
   @ResponseStatus(HttpStatus.OK)
   public List<Holiday> getHolidays(@RequestParam(required = false) String type,
         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
      return holidayService.getHolidaysFilter(type, from, to);
   }

}
