package io.summer.popin.global.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import io.summer.popin.global.dao.UrlMapper;
import io.summer.popin.global.dto.UrlResourceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AwsS3Service {

    private final UrlMapper urlMapper;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;

    private final AmazonS3 amazonS3;  //아마존 접근

    public List<String> uploadImage(List<MultipartFile> multipartFiles, UrlResourceDTO urlResourceDTO) {  //다중파일업로드
        List<String> urlList = new ArrayList<>();

        multipartFiles.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());
            String url = defaultUrl + fileName;

            try {
                InputStream inputStream = file.getInputStream();
                amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                urlResourceDTO.setUrl(url);
                urlMapper.insertUrl(urlResourceDTO);
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다.");
            }
            urlList.add(url);
        });
        return urlList;
    }

    public List<String> updateProfileImage(List<MultipartFile> multipartFiles, UrlResourceDTO urlResourceDTO) {  //다중파일업로드
        List<String> urlList = new ArrayList<>();

        multipartFiles.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());
            String url = defaultUrl + fileName;

            try {
                InputStream inputStream = file.getInputStream();
                amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                urlResourceDTO.setUrl(url);
                updateDbUrl(urlResourceDTO);
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다.");
            }
            urlList.add(url);
        });
        return urlList;
    }

    @Transactional
    public void updateDbUrl(UrlResourceDTO urlResourceDTO) {
        urlMapper.deleteUrl(urlResourceDTO);
        urlMapper.insertUrl(urlResourceDTO);
    }


    public void deleteImage(String fileName, Long urlNo) {
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
//        urlMapper.deleteUrl(urlNo);
    }

    private String createFileName(String filename) {
        return UUID.randomUUID().toString().concat(getFileExtension(filename));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일입니다.");
        }
    }
}
