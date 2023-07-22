package az.millisoft.first.controller;

import az.millisoft.first.entity.Reservation;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.repository.BranchRepository;
import az.millisoft.first.repository.ServiceRepository;
import az.millisoft.first.service.BarberService;
import az.millisoft.first.service.BranchService;
import az.millisoft.first.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class GeneralController {
    // String
    // ModelAndView : DB melumati ve View
    // RedirectView

    private final BarberService barberService;

    private final BranchService branchService;

    private final ServicesService servicesService;

    @GetMapping( "/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("barbers",barberService.getAll());
        modelAndView.addObject("branches",branchService.getAll());
        modelAndView.addObject("services",servicesService.getAll());
        modelAndView.addObject("reservation",new Reservation());
        return modelAndView;
    }



}
