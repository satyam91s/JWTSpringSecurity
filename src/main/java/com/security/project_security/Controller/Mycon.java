package com.security.project_security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class Mycon {

@GetMapping("/general")
 public ResponseEntity<String> generalUser(){
    return ResponseEntity.ok("Yes, I am general User");
  }

@GetMapping("/public")
 public ResponseEntity<String> publicUser(){
    return ResponseEntity.ok("Yes, I am Public User");
  }

@GetMapping("/admin")
 public ResponseEntity<String> Admin(){
    return ResponseEntity.ok("Yes, I am Admin");
  }
    



    
}
