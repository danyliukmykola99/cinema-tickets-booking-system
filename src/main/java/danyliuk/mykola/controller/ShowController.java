package danyliuk.mykola.controller;

import danyliuk.mykola.model.Show;
import danyliuk.mykola.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Mykola Danyliuk
 */
@Controller
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/all")
    public ModelAndView getShows(){
        ModelAndView m = new ModelAndView("shows");
        List<Show> shows = showService.findScheduled();
        m.addObject("shows",shows);
        return m;
    }

}
