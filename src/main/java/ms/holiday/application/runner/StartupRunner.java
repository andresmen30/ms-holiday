package ms.holiday.application.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ms.holiday.domain.service.HolidayService;

@Component
@RequiredArgsConstructor
public class StartupRunner implements ApplicationRunner {

   private final HolidayService holidayService;

   @Override
   public void run(ApplicationArguments args) {
      LoadHolidays.load(holidayService.getHolidays());
   }
}
