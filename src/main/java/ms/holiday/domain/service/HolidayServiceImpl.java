package ms.holiday.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.holiday.application.mapper.HolidayMapper;
import ms.holiday.application.runner.LoadHolidays;
import ms.holiday.domain.model.Holiday;
import ms.holiday.infraestructure.client.HolidayApiClient;
import ms.holiday.infraestructure.client.dto.HolidayApiResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

   private final HolidayApiClient holidayApiClient;

   private final HolidayMapper holidayMapper;

   public List<Holiday> getHolidays() {

      final HolidayApiResponse holidayApiResponse = holidayApiClient.getHolidays();
      return holidayMapper.toModel(holidayApiResponse.getData());

   }

   public List<Holiday> getHolidaysFilter(String type, LocalDate from, LocalDate to) {
      log.info("HolidayServiceImpl.getHolidaysFilter({}, {}, {})", type, from, to);
      return LoadHolidays.HOLIDAYS
            .stream()
            .filter(h -> type == null || h.getType().equalsIgnoreCase(type))
            .filter(h -> from == null || !h.getDate().isBefore(from))
            .filter(h -> to == null || !h.getDate().isAfter(to))
            .filter(h -> h.getDate() != null)
            .toList();
   }

}
