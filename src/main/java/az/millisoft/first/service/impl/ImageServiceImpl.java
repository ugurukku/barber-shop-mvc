package az.millisoft.first.service.impl;

import az.millisoft.first.entity.Barber;
import az.millisoft.first.exception.AddImageException;
import az.millisoft.first.exception.ImageNotFoundException;
import az.millisoft.first.service.BarberService;
import az.millisoft.first.service.ImageService;
import az.millisoft.first.service.ServicesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final BarberService barberService;
    private final ServicesService servicesService;

    @Override
    public byte[] getBarberImage(String id) {
        log.info("ImageService getBarberImage() request accepted");
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ugurk\\Desktop\\images\\barber\\" + id)) {
            return fileInputStream.readAllBytes();
        } catch (IOException exception) {
            throw new ImageNotFoundException("Image not found for barber  id : " + id.split("\\.")[0]);
        }
    }

    @Override
    public void addBarberImage(Integer id, MultipartFile file) {
        log.info("ImageService addBarberImage() request accepted");
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String fileName = id + "." + extension;

        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ugurk\\Desktop\\images\\barber\\" + fileName)) {
            fileOutputStream.write(file.getBytes());
        } catch (IOException exception) {
            throw new AddImageException("Exception occured during adding image for barber with id : " + id);
        }

        Barber barber = barberService.getById(id);
        barber.setImageLink("http://localhost:8080/images/barber/" + fileName);
        barberService.save(barber);

    }

    @Override
    public byte[] getServiceImage(String id) {
        log.info("ImageService getServiceImage() request accepted");

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ugurk\\Desktop\\images\\service\\" + id)) {
            return fileInputStream.readAllBytes();
        } catch (IOException exception) {
            throw new ImageNotFoundException("Image not found for service  id : " + id.split("\\.")[0]);
        }
    }

    @Override
    public void addServiceImage(Integer id, MultipartFile file) {
        log.info("ImageService addServiceImage() request accepted");
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String fileName = id + "." + extension;
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ugurk\\Desktop\\images\\service\\" + fileName)) {
            fileOutputStream.write(file.getBytes());
        } catch (IOException exception) {
            throw new AddImageException("Exception occured during adding image for service with id : " + id);
        }

        az.millisoft.first.entity.Service service = servicesService.getById(id);
        service.setImageLink("http://localhost:8080/images/service/" + fileName);
        servicesService.save(service);

    }
}
