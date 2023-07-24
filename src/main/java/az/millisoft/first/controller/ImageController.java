package az.millisoft.first.controller;

import az.millisoft.first.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;

    @RequestMapping(value = "/barber/{id}", method = RequestMethod.GET, produces = "image/webp")
    public byte[] getBarberImage(@PathVariable("id") String id)  {
        return service.getBarberImage(id);
    }

    @PostMapping("/barber/{barberId}")
    public RedirectView addBarberImage(@PathVariable("barberId") Integer id, MultipartFile file)  {
        service.addBarberImage(id, file);
        return new RedirectView("/admin/barbers/edit/" + id);
    }


    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET, produces = "image/webp")
    public byte[] getServiceImage(@PathVariable("id") String id)  {
        return service.getServiceImage(id);

    }

    @PostMapping("/service/{serviceId}")
    public RedirectView addServiceImage(@PathVariable("serviceId") Integer id, MultipartFile file)  {
        service.addServiceImage(id, file);
        return new RedirectView("/admin/services/edit/" + id);
    }


}
