package danyliuk.mykola.controller;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.dto.WeekScheduleDTO;
import danyliuk.mykola.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Mykola Danyliuk
 */
@Controller
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/")
    public ModelAndView getSchedule(){
        ModelAndView m = new ModelAndView("home");
        List<Show> scheduledShowsForWeek = showService.findScheduled();
        WeekScheduleDTO weekSchedule = new WeekScheduleDTO(scheduledShowsForWeek);
        m.addObject("weekSchedule", weekSchedule);
        return m;
    }

}
