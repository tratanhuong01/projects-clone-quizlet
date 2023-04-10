package com.quizlet.app.controller;

import com.quizlet.app.dto.UserDTO;
import com.quizlet.app.service.userService.UserService;
import com.quizlet.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        if(userService.findByUserName(userDTO.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        authenticationManager.authenticate(token);
        String jwtToken = jwtUtil.generate(userDTO.getUsername());
        return ResponseEntity.ok(jwtToken);
    }

}
