package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface TestService {
    ResponseEntity<?> RunCPUTest() throws InterruptedException;
}
