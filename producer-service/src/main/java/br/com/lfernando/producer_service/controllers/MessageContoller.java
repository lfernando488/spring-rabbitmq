package br.com.lfernando.producer_service.controllers;

import br.com.lfernando.producer_service.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produces")
public class MessageContoller {

    private final MessageService service;

    public MessageContoller(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message){
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }

}
