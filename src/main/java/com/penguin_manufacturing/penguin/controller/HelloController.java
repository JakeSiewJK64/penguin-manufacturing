package com.penguin_manufacturing.penguin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloController {

  @GetMapping("/hi")
  public String index() {
    return "greetings from springboot";
  }
}
