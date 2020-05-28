package com.example.demo.Controlleur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
@CrossOrigin("*")
@RestController

public class UploadController {
    @Autowired
    private StorageService storageService;

    List<String> files = new ArrayList<String>();

    @PostMapping("/post/")
    public HashMap<String,ResponseEntity<String>> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        HashMap<String,ResponseEntity<String>> hashMap=new HashMap<>();
        try {

            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
            storageService.store(file);
            files.add(file.getOriginalFilename());
            hashMap.put("data",ResponseEntity.status(HttpStatus.OK).body(message));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            hashMap.put("data",ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message));
        }
        return hashMap;
    }

    @GetMapping("/getallfiles")
    public ResponseEntity<List<String>> getListFiles(Model model) {
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(UploadController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(fileNames);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
