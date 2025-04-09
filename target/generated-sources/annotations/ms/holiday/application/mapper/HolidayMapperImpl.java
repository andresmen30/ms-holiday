package ms.holiday.application.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ms.holiday.domain.model.Holiday;
import ms.holiday.infraestructure.client.dto.HolidayApiDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T20:38:03-0500",
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

        Holiday.HolidayBuilder holiday = Holiday.builder();

        holiday.date( holidayApiDto.getDate() );
        holiday.title( holidayApiDto.getTitle() );
        holiday.type( holidayApiDto.getType() );
        holiday.inalienable( holidayApiDto.isInalienable() );
        holiday.extra( holidayApiDto.getExtra() );

        return holiday.build();
    }
}
