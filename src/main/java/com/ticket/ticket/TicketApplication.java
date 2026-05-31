package com.ticket.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TicketApplication {

  public static void main(String[] args) {
    SpringApplication.run(TicketApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/isAlive")
  public Boolean isAlive() {
    return true;
  }

}
