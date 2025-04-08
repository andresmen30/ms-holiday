package ms.holiday.application.runner;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import ms.holiday.domain.model.Holiday;

public class LoadHolidays {

   @Getter
   public static final List<Holiday> HOLIDAYS = new ArrayList<>();

   public static void load(final List<Holiday> holidays) {
      HOLIDAYS.addAll(holidays);
   }

}
