package android.rest.webService.controller;

import android.rest.webService.service.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class HomeController {
    @Autowired
    FileStorageService storageService;


    @GetMapping("/home")
    public String greeting() {
        return "home";
    }

    @GetMapping("/home/download")
    public ResponseEntity<Resource> downloadFile() {
        try {
            Resource file = storageService.load("app-debug.apk");
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"app-debug.apk\"").body(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }
}
