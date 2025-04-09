package ms.holiday.application.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;
import ms.holiday.domain.model.Holiday;
import ms.holiday.domain.service.HolidayService;
import ms.holiday.mock.HolidayMock;

@Slf4j
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(locations = "classpath:application.properties")
class HolidayControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockitoBean
   private HolidayService holidayService;

   @Value("${rest.request.mapping}")
   private String restUri;

   @Value("${rest.endpoint.holiday}")
   private String endpointHoliday;

   private List<Holiday> holidays;

   @BeforeEach
   public void setup() {
      holidays = HolidayMock.getHolidays();
   }

   @Test
   void getHolidays() throws Exception {
      log.info("(getHolidays)");
      when(holidayService.getHolidaysFilter(any(), any(), any())).thenReturn(holidays);
      mockMvc.perform(get(StringUtils.join(restUri, endpointHoliday)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
      log.info("(getHolidays) [[end]]");
   }

   @Test
   void getHolidaysFilter() throws Exception {
      log.info("(getHolidaysFilter)");
      when(holidayService.getHolidaysFilter(any(), any(), any())).thenReturn(holidays);
      mockMvc
            .perform(get(StringUtils.join(restUri, endpointHoliday))
                  .contentType(MediaType.APPLICATION_JSON)
                  .param("filter", "all")
                  .param("filter", "all")
                  .param("filter", "all"))
            .andExpect(status().isOk());
      log.info("(getHolidaysFilter) [[end]]");
   }

}