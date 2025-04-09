package ms.holiday.application.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.holiday.domain.service.HolidayService;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartupRunner implements ApplicationRunner {

   private final HolidayService holidayService;

   @Override
   public void run(ApplicationArguments args) {
      log.info("Starting holiday application");
      LoadHolidays.load(holidayService.getHolidays());
      log.info("Finished holiday application");
   }
}
