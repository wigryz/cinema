package com.it.cinemabackend.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/for-all")
    public ResponseEntity<String> getForAll() {
        return ResponseEntity.ok("Hello!");
    }

    @GetMapping("/hi-user")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello user!");
    }

    @GetMapping("/hi-admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello admin!");
    }

    @PostMapping("/hi-user")
    public ResponseEntity<String> postUser(@RequestBody String message) {
        return ResponseEntity.ok(message + "received!");
    }

    @PostMapping("/hi-admin")
    public ResponseEntity<String> postAdmin(@RequestBody String message) {
        return ResponseEntity.ok(message + "received!");
    }
}
