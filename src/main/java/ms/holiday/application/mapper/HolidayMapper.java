package ms.holiday.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import ms.holiday.domain.model.Holiday;
import ms.holiday.infraestructure.client.dto.HolidayApiDto;

@Mapper(componentModel = "spring")
public interface HolidayMapper {

   List<Holiday> toModel(final List<HolidayApiDto> holidays);

}
