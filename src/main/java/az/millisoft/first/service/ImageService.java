package az.millisoft.first.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    byte[] getBarberImage(String id);

    void addBarberImage(Integer id, MultipartFile file);

    byte[] getServiceImage(String id);

    void addServiceImage(Integer id, MultipartFile file);
}
