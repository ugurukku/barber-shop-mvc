package az.millisoft.first.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @RequestMapping(value = "/barber/{id}",method = RequestMethod.GET,produces = "image/webp")
    public byte[] getBarberImage(@PathVariable("id") String id) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ugurk\\Desktop\\images\\barber\\"+ id);
        return fileInputStream.readAllBytes();

    }

}
