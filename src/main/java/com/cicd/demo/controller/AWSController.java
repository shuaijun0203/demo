package com.cicd.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSController {

    @GetMapping("/aws")
    public ResponseEntity<String> apiTest(){

        return ResponseEntity.ok("asdsada asdasdsa");
    }
}
