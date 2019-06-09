package danyliuk.mykola.controller;

import danyliuk.mykola.configuration.UserPrincipal;
import danyliuk.mykola.model.domain.Movie;
import danyliuk.mykola.model.domain.RoleType;
import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.User;
import danyliuk.mykola.model.dto.*;
import danyliuk.mykola.service.MovieService;
import danyliuk.mykola.service.ShowService;
import danyliuk.mykola.service.TicketService;
import danyliuk.mykola.service.UserService;
import danyliuk.mykola.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Controller
public class MainController {

    @Autowired
    private ShowService showService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView getSchedule(){
        ModelAndView m = new ModelAndView("home");
        List<Show> scheduledShowsForWeek = showService.findScheduled();
        WeekScheduleDTO weekSchedule = new WeekScheduleDTO(scheduledShowsForWeek);
        m.addObject("weekSchedule", weekSchedule);
        return m;
    }

    @GetMapping("/shows")
    public ModelAndView getShow(@RequestParam(value = "showId" ,required = false) UUID showId) throws NotFoundException {
        if(showId==null){
            return new ModelAndView("redirect:/");
        }
        ModelAndView m = new ModelAndView("show");
        Show show = showService.findByID(showId);
        ShowDTO showDTO = new ShowDTO(show);
        TicketMatrixDTO ticketMatrix = new TicketMatrixDTO(show);
        m.addObject("show", showDTO);
        m.addObject("ticketMatrix", ticketMatrix);
        return m;
    }

    @PostMapping("/tickets/create")
    public String createTicket(
            @RequestParam("showId") UUID showID,
            @RequestParam("seat") Integer seat) throws NotFoundException {
        User user = null;
        ticketService.reserveTicket(showID, seat, user);
        return "/shows/showId=" + showID;
    }

    @GetMapping("/admin/shows")
    public ModelAndView getAdminShows(){
        ModelAndView m = new ModelAndView("admin_shows");
        List<ShowDTO> showDTOS = showService.findAll().stream()
                .map(ShowDTO::new).collect(Collectors.toList());
        m.addObject("shows", showDTOS);
        return m;
    }

    @GetMapping("/admin/movies")
    public ModelAndView getAdminMovies(){
        ModelAndView m = new ModelAndView("admin_movies");
        List<MovieDTO> movieDTOS = movieService.findAll().stream()
                .map(MovieDTO::new).collect(Collectors.toList());
        m.addObject("movies", movieDTOS);
        return m;
    }

    @GetMapping("/shows/cancel")
    public String cancelShow(@RequestParam("showId") UUID showID) throws NotFoundException {
        showService.cancelByShowID(showID);
        return "redirect:/admin/shows";
    }

    @GetMapping("/shows/start")
    public String startShow(@RequestParam("showId") UUID showID) throws NotFoundException {
        showService.startByShowID(showID);
        return "redirect:/admin/shows";
    }

    @GetMapping("/shows/finish")
    public String finishShow(@RequestParam("showId") UUID showID) throws NotFoundException {
        showService.finishByShowID(showID);
        return "redirect:/admin/shows";
    }

    @GetMapping("/movies/cancel")
    public String cancelMovieShows(@RequestParam("movieId") UUID movieId) {
        showService.cancelAllByMovieID(movieId);
        return "redirect:/admin/movies";
    }

    @PostMapping("/movies/create")
    public String createMovie(@RequestBody Movie movie){
        movieService.save(movie);
        return "redirect:/admin/movies";
    }

    @GetMapping("/shows/create")
    public ModelAndView prepareShowCreatingParams(){
        ModelAndView m = new ModelAndView("show_create");
        List<MovieDTO> movies = movieService.findAll().stream().map(MovieDTO::new).collect(Collectors.toList());
        List<TimeDTO> times = showService.getAvailableTime().stream().map(TimeDTO::new).collect(Collectors.toList());
        m.addObject("movies", movies);
        m.addObject("times", times);
        m.addObject("show", new ShowDTO());
        return m;
    }

    @PostMapping("/shows/create")
    public String createShow(@RequestBody ShowDTO show){
        UUID movieId = show.getMovieId();
        LocalDateTime startTime = LocalDateTime.parse(show.getStartDateTime());
        showService.create(movieId, startTime, startTime.plusHours(2));
        return "redirect:/admin/shows";
    }

    @GetMapping("/tickets")
    public ModelAndView getUserTickets(Authentication authentication){
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        List<TicketDTO> tickets = ticketService.findReservedByUser(user).stream()
                .map(TicketDTO::new).collect(Collectors.toList());
        ModelAndView m = new ModelAndView("tickets");
        m.addObject("tickets", tickets);
        return m;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error, String logout){
        if (error != null)
            model.addAttribute("error", "Your name and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("form", new LoginForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("form") LoginForm form){
        userService.save(form.parse());
        userService.login(form.getEmail(), form.getPassword());
        return "redirect:/";
    }

}