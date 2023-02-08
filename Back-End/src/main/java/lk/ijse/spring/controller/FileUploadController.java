package lk.ijse.spring.controller;

import lk.ijse.spring.service.FileService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/file_upload")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<ResponseUtil> getFile() {
        return new ResponseEntity<ResponseUtil>(new ResponseUtil(), HttpStatus.OK);
    }
}
