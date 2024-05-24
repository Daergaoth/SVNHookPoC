package com.daergaoth.svnhook.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class MyController {

    @GetMapping("/ip")
    public ResponseEntity<String> getData(){
        return new ResponseEntity<>("OKAY", HttpStatusCode.valueOf(200));
    }
}
