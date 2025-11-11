package br.com.lfernando.producer_service.controllers;

import br.com.lfernando.producer_service.services.MessageService;
import br.com.lfernando.producer_service.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.rabbitmq.dtos.ProductDTO;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping(value = "/products")
public class ProductContoller {

    private final ProductService service;

    public ProductContoller(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> produces(@RequestBody ProductDTO dto){
        service.createproduct(dto);
        return ResponseEntity.status(CREATED).build();
    }

}
