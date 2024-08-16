package kg.attractor.jobsearch.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageSrvice {
    String uploadAvatar (Long userid, MultipartFile file)  throws IOException;
}
