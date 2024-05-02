package com.hotelbooking.service;

import com.hotelbooking.entity.Image;
import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.repository.ImageRepository;
import com.hotelbooking.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    private  AWSService service;
    private ImageRepository imageRepository;
    private PropertyRepository propertyRepository;

    public ImageService(AWSService service, ImageRepository imageRepository, PropertyRepository propertyRepository) {
        this.service = service;
        this.imageRepository = imageRepository;
        this.propertyRepository = propertyRepository;
    }

    public Image addImage(long id, PropertyUser user, MultipartFile file, String bucketName) throws IOException {
        Property property = propertyRepository.findById(id).get();

        Image image= new Image();
        image.setProperty(property);
        image.setPropertyUser(user);
        String s = service.uploadFile(file, bucketName);
        image.setUrl(s);
        Image save = imageRepository.save(image);
        return save;

    }
}
