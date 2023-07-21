package az.millisoft.first.controller;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.entity.Branch;
import az.millisoft.first.entity.Service;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.repository.BranchRepository;
import az.millisoft.first.repository.ReservationRepository;
import az.millisoft.first.repository.ServiceRepository;
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

    private final ServiceRepository serviceRepository;

    private final BranchRepository branchRepository;

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
    public ModelAndView services(){
        ModelAndView modelAndView = new ModelAndView("services");
        modelAndView.addObject("services",serviceRepository.findAll());
        modelAndView.addObject("serviceRequest",new Service());
        return modelAndView;
    }

    @GetMapping( "/services/edit/{id}")
    public ModelAndView servicesEdit(@PathVariable("id") Integer id){
        Service service = serviceRepository.findById(id).orElseThrow();
        ModelAndView modelAndView = new ModelAndView("services-edit");
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping( "/services/edit")
    public RedirectView servicesEditPost(@ModelAttribute Service service){
        serviceRepository.save(service);
        return new RedirectView("/admin/services");
    }

    @GetMapping( "/branches")
    public ModelAndView branches(){
        ModelAndView modelAndView = new ModelAndView("branches");
        modelAndView.addObject("branches",branchRepository.findAll());
        modelAndView.addObject("branchRequest",new Branch());
        return modelAndView;
    }

    @GetMapping( "/branches/edit/{id}")
    public ModelAndView branchesEdit(@PathVariable("id") Integer id){
        Branch branch = branchRepository.findById(id).orElseThrow();
        ModelAndView modelAndView = new ModelAndView("branches-edit");
        modelAndView.addObject("branch", branch);
        return modelAndView;
    }

    @PostMapping( "/branches/edit")
    public RedirectView branchesEditPost(@ModelAttribute Branch branch){
        branchRepository.save(branch);
        return new RedirectView("/admin/branches");
    }


}
