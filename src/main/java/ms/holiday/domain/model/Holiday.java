package ms.holiday.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

   private LocalDate date;

   private String title;

   private String type;

   private boolean inalienable;

   private String extra;

}
