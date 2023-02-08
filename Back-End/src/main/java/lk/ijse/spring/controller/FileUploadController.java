package lk.ijse.spring.controller;

import lk.ijse.spring.service.FileService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file_upload")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<ResponseUtil> uploadFile(@RequestParam("fileChooser") MultipartFile file) {
        System.out.println(file);
        return new ResponseEntity<ResponseUtil>(new ResponseUtil(), HttpStatus.OK);
    }
}
