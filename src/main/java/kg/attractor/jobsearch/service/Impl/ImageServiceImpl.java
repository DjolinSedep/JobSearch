package kg.attractor.jobsearch.service.Impl;

import kg.attractor.jobsearch.dao.ImageDao;
import kg.attractor.jobsearch.service.ImageSrvice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageSrvice {
    private static final String UPLOAD_DIR ="upload" ;
    private final ImageDao imageDao;

    @Override
    public String uploadAvatar(Long userid, MultipartFile file)  throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String avatarPath = UPLOAD_DIR + userid + "_" + file.getOriginalFilename();
        file.transferTo(new File(avatarPath));
        imageDao.updateAvatar((userid), avatarPath);
        return avatarPath;
    }
}
