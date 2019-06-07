package danyliuk.mykola.controller;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import danyliuk.mykola.model.dto.ShowDTO;
import danyliuk.mykola.model.dto.TicketDTO;
import danyliuk.mykola.model.dto.WeekScheduleDTO;
import danyliuk.mykola.service.ShowService;
import danyliuk.mykola.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/shows")
    public ModelAndView getShow(@RequestParam("showId") UUID showId) throws NotFoundException {
        ModelAndView m = new ModelAndView("show");
        Show show = showService.findByID(showId);
        ShowDTO showDTO = new ShowDTO(show);
        List<Ticket> tickets = show.getTickets();
        TicketDTO[][] ticketMatrix = new TicketDTO[10][10];
        for(int i = 0; i<100 ; i++){
            ticketMatrix[i/10][i%10] = new TicketDTO(tickets.get(i));
        }
        m.addObject("show", showDTO);
        m.addObject("tickets", ticketMatrix);
        return m;
    }



}
