package dev.layseiras.HelloRecruiter.controller;

import dev.layseiras.HelloRecruiter.model.Hello;
import dev.layseiras.HelloRecruiter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("/generate")
    public Mono<String> generateEmail(@RequestBody Hello hello) {
        return helloService.getEmailBody(hello);
    }
}
