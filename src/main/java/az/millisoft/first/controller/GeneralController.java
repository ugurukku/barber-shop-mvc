package az.millisoft.first.controller;

import az.millisoft.first.entity.Reservation;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class GeneralController {
    // String
    // ModelAndView : DB melumati ve View
    // RedirectView

    private final BarberRepository barberRepository;

    private final BranchRepository branchRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("barbers",barberRepository.findAll());
        modelAndView.addObject("branches",branchRepository.findAll());
        modelAndView.addObject("reservation",new Reservation());
        return modelAndView;
    }

}
