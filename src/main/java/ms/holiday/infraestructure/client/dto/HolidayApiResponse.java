package ms.holiday.infraestructure.client.dto;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class HolidayApiResponse {

   private String status;

   private List<HolidayApiDto> data;

}
