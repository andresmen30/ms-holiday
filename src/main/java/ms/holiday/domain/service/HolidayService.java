package ms.holiday.domain.service;

import java.time.LocalDate;
import java.util.List;

import ms.holiday.domain.model.Holiday;

public interface HolidayService {

   List<Holiday> getHolidays();

   List<Holiday>  getHolidaysFilter(final String type, final LocalDate from, final LocalDate to);

}
