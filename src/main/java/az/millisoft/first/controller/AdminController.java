package az.millisoft.first.controller;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ReservationRepository reservationRepository;

    private final BarberRepository barberRepository;

    @GetMapping
    public String admin(){
        return "admin";
    }

    @GetMapping( "/reservations")
    public ModelAndView reservations(){
        ModelAndView modelAndView = new ModelAndView("reservations");
        modelAndView.addObject("reservations",reservationRepository.findAll());
        return modelAndView;
    }

    @PostMapping( "/reservations/{id}")
    public RedirectView removeReservation(@PathVariable("id") Integer id){
        reservationRepository.deleteById(id);
        return new RedirectView("/admin/reservations");
    }

    @GetMapping( "/barbers")
    public ModelAndView barbers(){
        ModelAndView modelAndView = new ModelAndView("barbers");
        modelAndView.addObject("barbers",barberRepository.findAll());
        modelAndView.addObject("barberRequest",new Barber());
        return modelAndView;
    }

    @PostMapping( "/barbers/edit")
    public RedirectView barbersEditPost(@ModelAttribute Barber barber){
       barberRepository.save(barber);
        return new RedirectView("/admin/barbers");
    }


    @GetMapping( "/barbers/edit/{id}")
    public ModelAndView barbersEdit(@PathVariable("id") Integer id){
        Barber barber = barberRepository.findById(id).orElseThrow();
        ModelAndView modelAndView = new ModelAndView("barbers-edit");
        modelAndView.addObject("barber", barber);
        return modelAndView;
    }

    @GetMapping( "/services")
    public String services(){
        return "services";
    }

    @GetMapping( "/branches")
    public String branches(){
        return "branches";
    }



}
