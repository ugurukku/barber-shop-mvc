package az.millisoft.first.controller;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.entity.Branch;
import az.millisoft.first.entity.Service;
import az.millisoft.first.repository.BarberRepository;
import az.millisoft.first.repository.BranchRepository;
import az.millisoft.first.repository.ReservationRepository;
import az.millisoft.first.repository.ServiceRepository;
import az.millisoft.first.service.BarberService;
import az.millisoft.first.service.BranchService;
import az.millisoft.first.service.ReservationService;
import az.millisoft.first.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ReservationService reservationService;

    private final BarberService barberService;

    private final ServicesService servicesService;

    private final BranchService branchService;

    @GetMapping
    public String admin(){
        return "admin";
    }

    @GetMapping( "/reservations")
    public ModelAndView reservations(){
        ModelAndView modelAndView = new ModelAndView("reservations");
        modelAndView.addObject("reservations",reservationService.getAll());
        return modelAndView;
    }

    @PostMapping( "/reservations/{id}")
    public RedirectView removeReservation(@PathVariable("id") Integer id){
        reservationService.deleteById(id);
        return new RedirectView("/admin/reservations");
    }

    @GetMapping( "/barbers")
    public ModelAndView barbers(){
        ModelAndView modelAndView = new ModelAndView("barbers");
        modelAndView.addObject("barbers",barberService.getAll());
        modelAndView.addObject("barberRequest",new Barber());
        return modelAndView;
    }

    @PostMapping( "/barbers/edit")
    public RedirectView barbersEditPost(@ModelAttribute Barber barber){
       barberService.save(barber);
        return new RedirectView("/admin/barbers");
    }


    @GetMapping( "/barbers/edit/{id}")
    public ModelAndView barbersEdit(@PathVariable("id") Integer id){
        Barber barber = barberService.getById(id);
        ModelAndView modelAndView = new ModelAndView("barbers-edit");
        modelAndView.addObject("barber", barber);
        return modelAndView;
    }

    @PostMapping("/barbers/delete/{id}")
    public RedirectView barbersDeletePost(@PathVariable("id") Integer id){
        barberService.deleteById(id);
        return new RedirectView("/admin/barbers");
    }

    @GetMapping( "/services")
    public ModelAndView services(){
        ModelAndView modelAndView = new ModelAndView("services");
        modelAndView.addObject("services",servicesService.getAll());
        modelAndView.addObject("serviceRequest",new Service());
        return modelAndView;
    }

    @GetMapping( "/services/edit/{id}")
    public ModelAndView servicesEdit(@PathVariable("id") Integer id){
        Service service = servicesService.getById(id);
        ModelAndView modelAndView = new ModelAndView("services-edit");
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping( "/services/edit")
    public RedirectView servicesEditPost(@ModelAttribute Service service){
        servicesService.save(service);
        return new RedirectView("/admin/services");
    }

    @PostMapping("/services/delete/{id}")
    public RedirectView servicesDeletePost(@PathVariable("id") Integer id){
        servicesService.deleteById(id);
        return new RedirectView("/admin/services");
    }

    @GetMapping( "/branches")
    public ModelAndView branches(){
        ModelAndView modelAndView = new ModelAndView("branches");
        modelAndView.addObject("branches",branchService.getAll());
        modelAndView.addObject("branchRequest",new Branch());
        return modelAndView;
    }

    @GetMapping( "/branches/edit/{id}")
    public ModelAndView branchesEdit(@PathVariable("id") Integer id){
        Branch branch = branchService.getById(id);
        ModelAndView modelAndView = new ModelAndView("branches-edit");
        modelAndView.addObject("branch", branch);
        return modelAndView;
    }

    @PostMapping( "/branches/edit")
    public RedirectView branchesEditPost(@ModelAttribute Branch branch){
        branchService.save(branch);
        return new RedirectView("/admin/branches");
    }

    @PostMapping("/branches/delete/{id}")
    public RedirectView branchesDeletePost(@PathVariable("id") Integer id){
        branchService.deleteById(id);
        return new RedirectView("/admin/branches");
    }


}
