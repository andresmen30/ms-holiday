package ms.holiday.infraestructure.client.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HolidayApiDto {

   private LocalDate date;

   private String title;

   private String type;

   private boolean inalienable;

   private String extra;

}
