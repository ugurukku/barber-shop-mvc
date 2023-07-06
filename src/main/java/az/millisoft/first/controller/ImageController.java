package az.millisoft.first.controller;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final BarberRepository barberRepository;

    @RequestMapping(value = "/barber/{id}",method = RequestMethod.GET,produces = "image/webp")
    public byte[] getBarberImage(@PathVariable("id") String id) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ugurk\\Desktop\\images\\barber\\"+ id);
        return fileInputStream.readAllBytes();

    }

    @PostMapping("/barber/{barberId}")
    public RedirectView addBarberImage(@PathVariable("barberId") Integer id, MultipartFile file) throws IOException {

        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String fileName = id + "." + extension;

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ugurk\\Desktop\\images\\barber\\" + fileName);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();

        Barber barber = barberRepository.findById(id).orElseThrow();
        barber.setImageLink("http://localhost:8080/images/barber/"+ fileName);
        barberRepository.save(barber);

        return new RedirectView("/admin/barbers/edit/" + id);
    }


}
