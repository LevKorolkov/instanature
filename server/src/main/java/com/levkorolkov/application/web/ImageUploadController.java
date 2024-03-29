package com.levkorolkov.application.web;

import com.levkorolkov.application.entity.ImageModel;
import com.levkorolkov.application.payload.response.MessageResponse;
import com.levkorolkov.application.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("api/image")
public class ImageUploadController {
    @Autowired
    private ImageUploadService imageUploadService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadImageToUser(@RequestParam("file") MultipartFile multipartFile,
                                                             Principal principal) throws IOException {
        imageUploadService.uploadImageToUser(multipartFile, principal);
        return new ResponseEntity<>(new MessageResponse("Image uploaded successfully"), HttpStatus.OK);
    }

    @PostMapping("/{postId}/upload")
    public ResponseEntity<MessageResponse> uploadImageToPost(@PathVariable("postId") String postId,
                                                             @RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException {
        imageUploadService.uploadImageToPost(file, principal, Long.parseLong(postId));
        return new ResponseEntity<>(new MessageResponse("Image uploaded successfully"), HttpStatus.OK);
    }

    @GetMapping("/profileImage")
    public ResponseEntity<ImageModel> getImageForUser(Principal principal) {
        ImageModel userImage = imageUploadService.getImageToUser(principal);
        return new ResponseEntity<>(userImage, HttpStatus.OK);
    }

    @GetMapping("/{postId}/image")
    public ResponseEntity<ImageModel> getImageToPost(@PathVariable("postId") String postId) {
        ImageModel imageModel = imageUploadService.getImageToPost(Long.parseLong(postId));
        return new ResponseEntity<>(imageModel, HttpStatus.OK);
    }
}
