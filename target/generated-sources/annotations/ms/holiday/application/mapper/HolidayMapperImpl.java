package ms.holiday.application.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ms.holiday.domain.model.Holiday;
import ms.holiday.infraestructure.client.dto.HolidayApiDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T18:48:49-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class HolidayMapperImpl implements HolidayMapper {

    @Override
    public List<Holiday> toModel(List<HolidayApiDto> holidays) {
        if ( holidays == null ) {
            return null;
        }

        List<Holiday> list = new ArrayList<Holiday>( holidays.size() );
        for ( HolidayApiDto holidayApiDto : holidays ) {
            list.add( holidayApiDtoToHoliday( holidayApiDto ) );
        }

        return list;
    }

    protected Holiday holidayApiDtoToHoliday(HolidayApiDto holidayApiDto) {
        if ( holidayApiDto == null ) {
            return null;
        }

        Holiday holiday = new Holiday();

        holiday.setDate( holidayApiDto.getDate() );
        holiday.setTitle( holidayApiDto.getTitle() );
        holiday.setType( holidayApiDto.getType() );
        holiday.setInalienable( holidayApiDto.isInalienable() );
        holiday.setExtra( holidayApiDto.getExtra() );

        return holiday;
    }
}
