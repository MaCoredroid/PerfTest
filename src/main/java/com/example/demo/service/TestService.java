package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface TestService {
    ResponseEntity<?> RunCPUTest() throws InterruptedException;
    ResponseEntity<?> RunCPULongTest() throws InterruptedException;
    ResponseEntity<?> RunCPUSingleTest() throws InterruptedException;
}
