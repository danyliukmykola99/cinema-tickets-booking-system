package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class WeekScheduleDTO {

    private DayScheduleDTO todaySchedule;
    private DayScheduleDTO tomorrowSchedule;
    private Set<DayScheduleDTO> nextFiveDaysSchedule;

    private Set<DayScheduleDTO> daySchedules;

    public WeekScheduleDTO(List<Show> scheduledShowsForWeek){
        LocalDate now = LocalDate.now();
        todaySchedule = new DayScheduleDTO(scheduledShowsForWeek, now);
        tomorrowSchedule = new DayScheduleDTO(scheduledShowsForWeek, now.plusDays(1));
        Set<DayScheduleDTO> nextFiveDaysSchedule = new LinkedHashSet<>();
        for (LocalDate date = now.plusDays(2); date.isBefore(now.plusDays(7)); date = date.plusDays(1)){
            nextFiveDaysSchedule.add(new DayScheduleDTO(scheduledShowsForWeek, date));
        }
        this.nextFiveDaysSchedule = nextFiveDaysSchedule;
        // TODO: 07.06.19 fix
        this.daySchedules = nextFiveDaysSchedule;
    }

}
