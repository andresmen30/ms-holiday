package ms.holiday.mock;

import java.time.LocalDate;
import java.util.List;

import ms.holiday.domain.model.Holiday;

public class HolidayMock {

   public static List<Holiday> getHolidays() {
      return List.of(Holiday
                  .builder()
                  .date(LocalDate.of(2025, 1, 1))
                  .title("Año Nuevo")
                  .type("Civil")
                  .inalienable(true)
                  .extra("Civil e Irrenunciable")
                  .build(),

            Holiday.builder().date(LocalDate.of(2025, 4, 18)).title("Viernes Santo").type("Religioso").inalienable(false).extra("Religioso").build(),

            Holiday
                  .builder()
                  .date(LocalDate.of(2025, 5, 1))
                  .title("Día Nacional del Trabajo")
                  .type("Civil")
                  .inalienable(true)
                  .extra("Civil e Irrenunciable")
                  .build(),

            Holiday
                  .builder()
                  .date(LocalDate.of(2025, 6, 20))
                  .title("Día Nacional de los Pueblos Indígenas")
                  .type("Civil")
                  .inalienable(false)
                  .extra("Civil")
                  .build(),

            Holiday
                  .builder()
                  .date(LocalDate.of(2025, 12, 25))
                  .title("Navidad")
                  .type("Religioso")
                  .inalienable(true)
                  .extra("Religioso e Irrenunciable")
                  .build());
   }

}
