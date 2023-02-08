package lk.ijse.spring.controller;

import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/file_upload")
public class FileUploadController {
    @GetMapping
    public ResponseEntity<ResponseUtil> getFile(String id) {
        return new ResponseEntity<ResponseUtil>(new ResponseUtil("OK", "Successfully Received", id), HttpStatus.OK);
    }
}
