package az.millisoft.first.controller;

import az.millisoft.first.entity.Reservation;
import az.millisoft.first.repository.ReservationRepository;
import az.millisoft.first.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

//
// Cloud: Storage and Computing
// Provider: Digitalocean,Azure, AWS
//
//

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService service;

    @PostMapping
    public RedirectView addReservation(@ModelAttribute Reservation reservation){
        System.out.println(reservation);
        service.save(reservation);
        return new RedirectView("/");
    }

}
