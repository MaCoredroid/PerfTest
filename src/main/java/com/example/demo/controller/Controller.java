package com.example.demo.controller;


import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/test")
public class Controller {

  @Autowired
  WebApplicationContext applicationContext;


  @RequestMapping(value = "/cpu", method = {RequestMethod.OPTIONS, RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<?> testCPU() throws InterruptedException {
    TestService testService=applicationContext.getBean(TestService.class);
    return testService.RunCPUTest();
  }

  @RequestMapping(value = "/cpuSingle", method = {RequestMethod.OPTIONS, RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<?> testCPUSingle() throws InterruptedException {
    TestService testService=applicationContext.getBean(TestService.class);
    return testService.RunCPUSingleTest();
  }

  @RequestMapping(value = "/cpuLong", method = {RequestMethod.OPTIONS, RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<?> testCPULong() throws InterruptedException {
    TestService testService=applicationContext.getBean(TestService.class);
    return testService.RunCPULongTest();

  }

}
