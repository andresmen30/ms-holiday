package ms.holiday.infraestructure.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import ms.holiday.infraestructure.client.dto.HolidayApiResponse;

@Component
public class HolidayApiClientImpl implements HolidayApiClient {

   @Value("${rest.client.holidays.url}")
   private String baseUrl;

   @Value("${rest.client.holidays.uri}")
   private String holidaysUri;

   public WebClient getWebClient() {
      return WebClient.builder().baseUrl(this.baseUrl).defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();
   }

   public HolidayApiResponse getHolidays() {

      return getWebClient().get().uri(holidaysUri).retrieve()
                           .bodyToMono(HolidayApiResponse.class).block();

   }

}
